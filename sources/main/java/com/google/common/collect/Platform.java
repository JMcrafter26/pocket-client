/*
 * Copyright (C) 2008 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.common.collect;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps.EntryTransformer;

/**
 * Methods factored out so that they can be emulated differently in GWT.
 *
 * @author Hayward Chan
 */
@GwtCompatible(emulated = true)
final class Platform {
	/**
	 * Returns a new array of the given length with the same type as a reference
	 * array.
	 *
	 * @param reference any array of the desired type
	 * @param length    the length of the new array
	 */
	static <T> T[] newArray(T[] reference, int length) {
		Class<?> type = reference.getClass().getComponentType();

		// the cast is safe because
		// result.getClass() == reference.getClass().getComponentType()
		@SuppressWarnings("unchecked")
		T[] result = (T[]) Array.newInstance(type, length);
		return result;
	}

	static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
		return Collections.newSetFromMap(map);
	}

	static <K, V1, V2> SortedMap<K, V2> mapsTransformEntriesSortedMap(SortedMap<K, V1> fromMap,
			EntryTransformer<? super K, ? super V1, V2> transformer) {
		return (fromMap instanceof NavigableMap) ? Maps.transformEntries((NavigableMap<K, V1>) fromMap, transformer)
				: Maps.transformEntriesIgnoreNavigable(fromMap, transformer);
	}

	static <K, V> SortedMap<K, V> mapsAsMapSortedSet(SortedSet<K> set, Function<? super K, V> function) {
		return (set instanceof NavigableSet) ? Maps.asMap((NavigableSet<K>) set, function)
				: Maps.asMapSortedIgnoreNavigable(set, function);
	}

	static <E> SortedSet<E> setsFilterSortedSet(SortedSet<E> set, Predicate<? super E> predicate) {
		return (set instanceof NavigableSet) ? Sets.filter((NavigableSet<E>) set, predicate)
				: Sets.filterSortedIgnoreNavigable(set, predicate);
	}

	static <K, V> SortedMap<K, V> mapsFilterSortedMap(SortedMap<K, V> map,
			Predicate<? super Map.Entry<K, V>> predicate) {
		return (map instanceof NavigableMap) ? Maps.filterEntries((NavigableMap<K, V>) map, predicate)
				: Maps.filterSortedIgnoreNavigable(map, predicate);
	}

	private Platform() {
	}
}
