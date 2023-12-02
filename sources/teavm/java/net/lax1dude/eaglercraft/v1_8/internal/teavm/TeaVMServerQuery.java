package net.lax1dude.eaglercraft.v1_8.internal.teavm;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;
import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;
import org.teavm.jso.dom.events.Event;
import org.teavm.jso.dom.events.EventListener;
import org.teavm.jso.dom.events.MessageEvent;
import org.teavm.jso.typedarrays.ArrayBuffer;
import org.teavm.jso.typedarrays.Int8Array;
import org.teavm.jso.websocket.WebSocket;

import net.lax1dude.eaglercraft.v1_8.internal.EnumServerRateLimit;
import net.lax1dude.eaglercraft.v1_8.internal.IServerQuery;
import net.lax1dude.eaglercraft.v1_8.internal.QueryResponse;
import net.lax1dude.eaglercraft.v1_8.log4j.LogManager;
import net.lax1dude.eaglercraft.v1_8.log4j.Logger;

/**
 * Copyright (c) 2022-2023 LAX1DUDE. All Rights Reserved.
 * 
 * WITH THE EXCEPTION OF PATCH FILES, MINIFIED JAVASCRIPT, AND ALL FILES
 * NORMALLY FOUND IN AN UNMODIFIED MINECRAFT RESOURCE PACK, YOU ARE NOT ALLOWED
 * TO SHARE, DISTRIBUTE, OR REPURPOSE ANY FILE USED BY OR PRODUCED BY THE
 * SOFTWARE IN THIS REPOSITORY WITHOUT PRIOR PERMISSION FROM THE PROJECT AUTHOR.
 * 
 * NOT FOR COMMERCIAL OR MALICIOUS USE
 * 
 * (please read the 'LICENSE' file this repo's root directory for more info)
 * 
 */
public class TeaVMServerQuery implements IServerQuery {

	public static final Logger logger = LogManager.getLogger("WebSocketQuery");

	private final List<QueryResponse> queryResponses = new LinkedList();
	private final List<byte[]> queryResponsesBytes = new LinkedList();

	protected final String uri;
	protected final String accept;
	protected final WebSocket sock;
	protected boolean open = true;
	protected boolean alive = false;
	protected long pingStart = -1l;
	protected long pingTimer = -1l;
	private EnumServerRateLimit rateLimit = EnumServerRateLimit.OK;

	public TeaVMServerQuery(String uri, String accept) {
		this.uri = uri;
		this.accept = accept;
		this.sock = WebSocket.create(uri);
		initHandlers();
	}

	@JSBody(params = { "obj" }, script = "return typeof obj === \"string\";")
	private static native boolean isString(JSObject obj);

	protected void initHandlers() {
		sock.setBinaryType("arraybuffer");
		TeaVMUtils.addEventListener(sock, "open", new EventListener<Event>() {
			@Override
			public void handleEvent(Event evt) {
				sock.send("Accept: " + accept);
			}
		});
		TeaVMUtils.addEventListener(sock, "close", new EventListener<Event>() {
			@Override
			public void handleEvent(Event evt) {
				open = false;
			}
		});
		TeaVMUtils.addEventListener(sock, "message", new EventListener<MessageEvent>() {
			@Override
			public void handleEvent(MessageEvent evt) {
				alive = true;
				if(pingTimer == -1) {
					pingTimer = System.currentTimeMillis() - pingStart;
					if(pingTimer < 1) {
						pingTimer = 1;
					}
				}
				if(isString(evt.getData())) {
					String str = evt.getDataAsString();
					if(str.equalsIgnoreCase("BLOCKED")) {
						logger.error("Reached full IP ratelimit for {}!", uri);
						rateLimit = EnumServerRateLimit.BLOCKED;
						return;
					}
					if(str.equalsIgnoreCase("LOCKED")) {
						logger.error("Reached full IP ratelimit lockout for {}!", uri);
						rateLimit = EnumServerRateLimit.LOCKED_OUT;
						return;
					}
					try {
						JSONObject obj = new JSONObject(str);
						if("blocked".equalsIgnoreCase(obj.optString("type", null))) {
							logger.error("Reached query ratelimit for {}!", uri);
							rateLimit = EnumServerRateLimit.BLOCKED;
						}else if("locked".equalsIgnoreCase(obj.optString("type", null))) {
							logger.error("Reached query ratelimit lockout for {}!", uri);
							rateLimit = EnumServerRateLimit.LOCKED_OUT;
						}else {
							QueryResponse response = new QueryResponse(obj, pingTimer);
							synchronized(queryResponses) {
								queryResponses.add(response);
							}
						}
					}catch(Throwable t) {
						logger.error("Exception thrown parsing websocket query response from \"" + uri + "\"!");
						logger.error(t);
					}
				}else {
					synchronized(queryResponsesBytes) {
						Int8Array packetBytes = Int8Array.create(evt.getDataAsArray());
						byte[] data = new byte[packetBytes.getLength()];
						for(int i = 0; i < data.length; ++i) {
							data[i] = packetBytes.get(i);
						}
						queryResponsesBytes.add(data);
					}
				}
			}
		});
		TeaVMUtils.addEventListener(sock, "error", new EventListener<Event>() {
			@Override
			public void handleEvent(Event evt) {
				sock.close();
				open = false;
			}
		});
	}

	@Override
	public void send(String str) {
		if(open) {
			sock.send(str);
		}
	}

	@JSBody(params = { "sock", "buffer" }, script = "sock.send(buffer);")
	private static native void nativeBinarySend(WebSocket sock, ArrayBuffer buffer);

	@Override
	public void send(byte[] bytes) {
		if(open) {
			Int8Array arr = Int8Array.create(bytes.length);
			arr.set(bytes, 0);
			nativeBinarySend(sock, arr.getBuffer());
		}
	}

	@Override
	public int responsesAvailable() {
		synchronized(queryResponses) {
			return queryResponses.size();
		}
	}

	@Override
	public QueryResponse getResponse() {
		synchronized(queryResponses) {
			if(queryResponses.size() > 0) {
				return queryResponses.remove(0);
			}else {
				return null;
			}
		}
	}

	@Override
	public int binaryResponsesAvailable() {
		synchronized(queryResponsesBytes) {
			return queryResponsesBytes.size();
		}
	}

	@Override
	public byte[] getBinaryResponse() {
		synchronized(queryResponsesBytes) {
			if(queryResponsesBytes.size() > 0) {
				return queryResponsesBytes.remove(0);
			}else {
				return null;
			}
		}
	}

	@Override
	public QueryReadyState readyState() {
		return open ? (alive ? QueryReadyState.OPEN : QueryReadyState.CONNECTING)
				: (alive ? QueryReadyState.CLOSED : QueryReadyState.FAILED);
	}

	@Override
	public void close() {
		if(open) {
			open = false;
			sock.close();
		}
	}

	@Override
	public EnumServerRateLimit getRateLimit() {
		return rateLimit;
	}
}
