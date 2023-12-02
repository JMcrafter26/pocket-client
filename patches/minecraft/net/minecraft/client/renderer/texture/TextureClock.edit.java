
# Eagler Context Redacted Diff
# Copyright (c) 2023 lax1dude. All rights reserved.

# Version: 1.0
# Author: lax1dude

> INSERT  2 : 4  @  2

+ import net.lax1dude.eaglercraft.v1_8.internal.IFramebufferGL;
+ import net.lax1dude.eaglercraft.v1_8.minecraft.EaglerTextureAtlasSprite;

> DELETE  1  @  1 : 3

> CHANGE  2 : 3  @  2 : 3

~ public class TextureClock extends EaglerTextureAtlasSprite {

> CHANGE  7 : 8  @  7 : 8

~ 	public void updateAnimation(IFramebufferGL[] copyColorFramebuffer) {

> CHANGE  33 : 35  @  33 : 35

~ 				animationCache.copyFrameLevelsToTex2D(this.frameCounter, this.originX, this.originY, this.width,
~ 						this.height, copyColorFramebuffer);

> INSERT  4 : 5  @  4

+ 

> EOF
