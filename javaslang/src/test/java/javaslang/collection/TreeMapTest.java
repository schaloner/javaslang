/*     / \____  _    _  ____   ______  / \ ____  __    _______
 *    /  /    \/ \  / \/    \ /  /\__\/  //    \/  \  //  /\__\   JΛVΛSLΛNG
 *  _/  /  /\  \  \/  /  /\  \\__\\  \  //  /\  \ /\\/ \ /__\ \   Copyright 2014-2017 Javaslang, http://javaslang.io
 * /___/\_/  \_/\____/\_/  \_/\__\/__/\__\_/  \_//  \__/\_____/   Licensed under the Apache License, Version 2.0
 */
package javaslang.collection;

import javaslang.Tuple;
import javaslang.Tuple2;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.util.Comparator.nullsFirst;
import static javaslang.API.List;
import static javaslang.API.Tuple;
import static javaslang.Serializables.deserialize;
import static javaslang.Serializables.serialize;
import static javaslang.collection.Comparators.naturalComparator;

public class TreeMapTest extends AbstractSortedMapTest {

    @Override
    protected String className() {
        return "TreeMap";
    }

    @Override
    <T1, T2> java.util.Map<T1, T2> javaEmptyMap() {
        return new java.util.TreeMap<>();
    }

    @Override
    protected <T1 extends Comparable<? super T1>, T2> TreeMap<T1, T2> emptyMap() {
        return TreeMap.empty();
    }

    @Override
    protected boolean emptyMapShouldBeSingleton() {
        return false;
    }

    @Override
    protected boolean isDistinctElements() {
        return true;
    }

    @Override
    protected boolean emptyShouldBeSingleton() {
        return false;
    }

    @Override
    protected <T> Collector<Tuple2<Integer, T>, ArrayList<Tuple2<Integer, T>>, ? extends Map<Integer, T>> mapCollector() {
        return TreeMap.collector();
    }

    @SuppressWarnings("varargs")
    @SafeVarargs
    @Override
    protected final <K extends Comparable<? super K>, V> TreeMap<K, V> mapOfTuples(Tuple2<? extends K, ? extends V>... entries) {
        return TreeMap.ofEntries(entries);
    }

    @SuppressWarnings("varargs")
    @SafeVarargs
    @Override
    protected final <K extends Comparable<? super K>, V> TreeMap<K, V> mapOfEntries(java.util.Map.Entry<? extends K, ? extends V>... entries) {
        return TreeMap.ofEntries(entries);
    }

    @Override
    protected <K extends Comparable<? super K>, V> TreeMap<K, V> mapOf(K k1, V v1) {
        return TreeMap.of(k1, v1);
    }

    @Override
    protected <K extends Comparable<? super K>, V> TreeMap<K, V> mapOf(K k1, V v1, K k2, V v2) {
        return TreeMap.of(k1, v1, k2, v2);
    }

    @Override
    protected <K extends Comparable<? super K>, V> TreeMap<K, V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3) {
        return TreeMap.of(k1, v1, k2, v2, k3, v3);
    }

    @Override
    protected <K extends Comparable<? super K>, V> TreeMap<K, V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return TreeMap.of(k1, v1, k2, v2, k3, v3, k4, v4);
    }

    @Override
    protected <K extends Comparable<? super K>, V> TreeMap<K, V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return TreeMap.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
    }

    @Override
    protected <K extends Comparable<? super K>, V> TreeMap<K, V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        return TreeMap.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
    }

    @Override
    protected <K extends Comparable<? super K>, V> TreeMap<K, V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        return TreeMap.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
    }

    @Override
    protected <K extends Comparable<? super K>, V> TreeMap<K, V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        return TreeMap.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
    }

    @Override
    protected <K extends Comparable<? super K>, V> TreeMap<K, V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        return TreeMap.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9);
    }

    @Override
    protected <K extends Comparable<? super K>, V> TreeMap<K, V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        return TreeMap.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10);
    }

    @Override
    protected <K extends Comparable<? super K>, V> TreeMap<K, V> mapOfNullKey(K k1, V v1, K k2, V v2) {
        return TreeMap.of(nullsFirst(naturalComparator()), k1, v1, k2, v2);
    }

    @Override
    protected <K extends Comparable<? super K>, V> TreeMap<K, V> mapOfNullKey(K k1, V v1, K k2, V v2, K k3, V v3) {
        return TreeMap.of(nullsFirst(naturalComparator()), k1, v1, k2, v2, k3, v3);
    }

    @Override
    protected <T, K extends Comparable<? super K>, V> TreeMap<K, V> mapOf(Stream<? extends T> stream, Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends V> valueMapper) {
        return TreeMap.ofAll(stream, keyMapper, valueMapper);
    }

    @Override
    protected <T, K extends Comparable<? super K>, V> TreeMap<K, V> mapOf(Stream<? extends T> stream, Function<? super T, Tuple2<? extends K, ? extends V>> f) {
        return TreeMap.ofAll(stream, f);
    }

    @Override
    protected <K extends Comparable<? super K>, V> TreeMap<K, V> mapTabulate(int n, Function<? super Integer, ? extends Tuple2<? extends K, ? extends V>> f) {
        return TreeMap.tabulate(n, f);
    }

    @Override
    protected <K extends Comparable<? super K>, V> TreeMap<K, V> mapFill(int n, Supplier<? extends Tuple2<? extends K, ? extends V>> s) {
        return TreeMap.fill(n, s);
    }

    // -- construct

    @Test
    public void shouldReturnSingletonFromTupleUsingComparator() {
        final TreeMap<Integer, String> actual = TreeMap.of(naturalComparator(), Tuple.of(1, "1"));
        final java.util.Map<Integer, String> expected = asJavaMap(asJavaEntry(1, "1"));
        assertThat(actual.toJavaMap()).isEqualTo(expected);
    }

    @Test
    public void shouldConstructFrom1EntryWithComparator() {
        final Map<Integer, String> actual = TreeMap.of(naturalComparator(), 1, "1");
        final java.util.Map<Integer, String> expected = asJavaMap(asJavaEntry(1, "1"));
        assertThat(actual.toJavaMap()).isEqualTo(expected);
    }

    @Test
    public void shouldConstructFrom2EntriesWithComparator() {
        final Map<Integer, String> actual = TreeMap.of(naturalComparator(), 1, "1", 2, "2");
        final java.util.Map<Integer, String> expected = asJavaMap(asJavaEntry(1, "1"), asJavaEntry(2, "2"));
        assertThat(actual.toJavaMap()).isEqualTo(expected);
    }

    @Test
    public void shouldConstructFrom3EntriesWithComparator() {
        final Map<Integer, String> actual = TreeMap.of(naturalComparator(), 1, "1", 2, "2", 3, "3");
        final java.util.Map<Integer, String> expected = asJavaMap(asJavaEntry(1, "1"), asJavaEntry(2, "2"), asJavaEntry(3, "3"));
        assertThat(actual.toJavaMap()).isEqualTo(expected);
    }

    @Test
    public void shouldConstructFrom4EntriesWithComparator() {
        final Map<Integer, String> actual = TreeMap.of(naturalComparator(), 1, "1", 2, "2", 3, "3", 4, "4");
        final java.util.Map<Integer, String> expected = asJavaMap(asJavaEntry(1, "1"), asJavaEntry(2, "2"), asJavaEntry(3, "3"), asJavaEntry(4, "4"));
        assertThat(actual.toJavaMap()).isEqualTo(expected);
    }

    @Test
    public void shouldConstructFrom5EntriesWithComparator() {
        final Map<Integer, String> actual = TreeMap.of(naturalComparator(), 1, "1", 2, "2", 3, "3", 4, "4", 5, "5");
        final java.util.Map<Integer, String> expected = asJavaMap(asJavaEntry(1, "1"), asJavaEntry(2, "2"), asJavaEntry(3, "3"), asJavaEntry(4, "4"), asJavaEntry(5, "5"));
        assertThat(actual.toJavaMap()).isEqualTo(expected);
    }

    @Test
    public void shouldConstructFrom6EntriesWithComparator() {
        final Map<Integer, String> actual = TreeMap.of(naturalComparator(), 1, "1", 2, "2", 3, "3", 4, "4", 5, "5", 6, "6");
        final java.util.Map<Integer, String> expected = asJavaMap(asJavaEntry(1, "1"), asJavaEntry(2, "2"), asJavaEntry(3, "3"), asJavaEntry(4, "4"), asJavaEntry(5, "5"), asJavaEntry(6, "6"));
        assertThat(actual.toJavaMap()).isEqualTo(expected);
    }

    @Test
    public void shouldConstructFrom7EntriesWithComparator() {
        final Map<Integer, String> actual = TreeMap.of(naturalComparator(), 1, "1", 2, "2", 3, "3", 4, "4", 5, "5", 6, "6", 7, "7");
        final java.util.Map<Integer, String> expected = asJavaMap(asJavaEntry(1, "1"), asJavaEntry(2, "2"), asJavaEntry(3, "3"), asJavaEntry(4, "4"), asJavaEntry(5, "5"), asJavaEntry(6, "6"), asJavaEntry(7, "7"));
        assertThat(actual.toJavaMap()).isEqualTo(expected);
    }

    @Test
    public void shouldConstructFrom8EntriesWithComparator() {
        final Map<Integer, String> actual = TreeMap.of(naturalComparator(), 1, "1", 2, "2", 3, "3", 4, "4", 5, "5", 6, "6", 7, "7", 8, "8");
        final java.util.Map<Integer, String> expected = asJavaMap(asJavaEntry(1, "1"), asJavaEntry(2, "2"), asJavaEntry(3, "3"), asJavaEntry(4, "4"), asJavaEntry(5, "5"), asJavaEntry(6, "6"), asJavaEntry(7, "7"), asJavaEntry(8, "8"));
        assertThat(actual.toJavaMap()).isEqualTo(expected);
    }

    @Test
    public void shouldConstructFrom9EntriesWithComparator() {
        final Map<Integer, String> actual = TreeMap.of(naturalComparator(), 1, "1", 2, "2", 3, "3", 4, "4", 5, "5", 6, "6", 7, "7", 8, "8", 9, "9");
        final java.util.Map<Integer, String> expected = asJavaMap(asJavaEntry(1, "1"), asJavaEntry(2, "2"), asJavaEntry(3, "3"), asJavaEntry(4, "4"), asJavaEntry(5, "5"), asJavaEntry(6, "6"), asJavaEntry(7, "7"), asJavaEntry(8, "8"), asJavaEntry(9, "9"));
        assertThat(actual.toJavaMap()).isEqualTo(expected);
    }

    @Test
    public void shouldConstructFrom10EntriesWithComparator() {
        final Map<Integer, String> actual = TreeMap.of(naturalComparator(), 1, "1", 2, "2", 3, "3", 4, "4", 5, "5", 6, "6", 7, "7", 8, "8", 9, "9", 10, "10");
        final java.util.Map<Integer, String> expected = asJavaMap(asJavaEntry(1, "1"), asJavaEntry(2, "2"), asJavaEntry(3, "3"), asJavaEntry(4, "4"), asJavaEntry(5, "5"), asJavaEntry(6, "6"), asJavaEntry(7, "7"), asJavaEntry(8, "8"), asJavaEntry(9, "9"), asJavaEntry(10, "10"));
        assertThat(actual.toJavaMap()).isEqualTo(expected);
    }

    // -- static factories

    @Test
    public void shouldCreateOfEntriesUsingNoComparator() {
        final List<Tuple2<Integer, String>> expected = List(Tuple(1, "a"), Tuple(2, "b"));
        final TreeMap<Integer, String> actual = TreeMap.ofEntries(expected);
        assertThat(actual.toList()).isEqualTo(expected);
    }

    @Test
    public void shouldCreateOfEntriesUsingNaturalComparator() {
        final List<Tuple2<Integer, String>> expected = List(Tuple(1, "a"), Tuple(2, "b"));
        final TreeMap<Integer, String> actual = TreeMap.ofEntries(naturalComparator(), expected);
        assertThat(actual.toList()).isEqualTo(expected);
    }

    @Test
    public void shouldCreateOfEntriesUsingKeyComparator() {
        final TreeMap<Integer, String> actual = TreeMap.ofEntries(naturalComparator(), asJavaEntry(1, "a"), asJavaEntry(2, "b"));
        final List<Tuple2<Integer, String>> expected = List(Tuple(1, "a"), Tuple(2, "b"));
        assertThat(actual.toList()).isEqualTo(expected);
    }

    // -- static narrow

    @Test
    public void shouldNarrowTreeMap() {
        final TreeMap<Integer, Double> int2doubleMap = mapOf(1, 1.0d);
        final TreeMap<Integer, Number> number2numberMap = TreeMap.narrow(int2doubleMap);
        final int actual = number2numberMap.put(2, new BigDecimal("2.0")).values().sum().intValue();
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void shouldScan() {
        final TreeMap<String, Integer> tm = TreeMap.ofEntries(Tuple.of("one", 1), Tuple.of("two", 2));
        final TreeMap<String, Integer> result = tm.scan(Tuple.of("z", 0), (t1, t2) -> Tuple.of(t1._1 + t2._1, t1._2 + t2._2));
        assertThat(result).isEqualTo(TreeMap.ofEntries(Tuple.of("z", 0), Tuple.of("zone", 1), Tuple.of("zonetwo", 3)));
    }

    @Test
    public void shouldScanLeft() {
        final TreeMap<String, Integer> tm = TreeMap.ofEntries(Tuple.of("one", 1), Tuple.of("two", 2));
        final Seq<Tuple2<String, Integer>> result = tm.scanLeft(Tuple.of("z", 0), (t1, t2) -> Tuple.of(t1._1 + t2._1, t1._2 + t2._2));
        assertThat(result).isEqualTo(List.of(Tuple.of("z", 0), Tuple.of("zone", 1), Tuple.of("zonetwo", 3)));
    }

    @Test
    public void shouldScanRight() {
        final TreeMap<String, Integer> tm = TreeMap.ofEntries(Tuple.of("one", 1), Tuple.of("two", 2));
        final Seq<String> result = tm.scanRight("z", (t1, acc) -> acc + CharSeq.of(t1._1).reverse());
        assertThat(result).isEqualTo(List.of("zowteno", "zowt", "z"));
    }

    @Test
    public void shouldWrapMap() {
        final java.util.Map<Integer, Integer> source = new java.util.HashMap<>();
        source.put(1, 2);
        source.put(3, 4);
        assertThat(TreeMap.ofAll(source)).isEqualTo(emptyIntInt().put(1, 2).put(3, 4));
    }

    // -- ofAll

    @Test
    public void shouldCreateKeyComparatorForJavaUtilMap() {
        final TreeMap<String, Integer> actual = TreeMap.ofAll(mapOfTuples(Tuple.of("c", 0), Tuple.of("a", 0), Tuple.of("b", 0)).toJavaMap());
        final List<String> expected = List.of("a", "b", "c");
        assertThat(actual.keySet().toList()).isEqualTo(expected);
    }

    @Test
    public void shouldSerializeDeserializeNonEmptyMap() {
        final Object expected = TreeMap.ofAll(Collections.singletonMap(0, 1));
        final Object actual = deserialize(serialize(expected));
        assertThat(actual).isEqualTo(expected);
    }

    // -- flatMap

    @Test
    public void shouldReturnATreeMapWithCorrectComparatorWhenFlatMappingToEmpty() {

        final TreeMap<Integer, String> testee = TreeMap.of(Comparator.naturalOrder(), 1, "1", 2, "2");
        assertThat(testee.head()).isEqualTo(Tuple(1, "1"));

        final TreeMap<Integer, String> actual = testee.flatMap(Comparator.reverseOrder(), (k, v) -> List.empty());
        assertThat(actual).isEmpty();

        final TreeMap<Integer, String> actualSorted = actual.put(1, "1").put(2, "2");
        assertThat(actualSorted.head()).isEqualTo(Tuple(2, "2"));
    }

    // -- map

    @Test
    public void shouldReturnModifiedKeysMapWithNonUniqueMapperAndPredictableOrder() {
        final TreeMap<Integer, String> actual = TreeMap
                .of(3, "3", 1, "1", 2, "2")
                .mapKeys(Integer::toHexString).mapKeys(String::length);
        final TreeMap<Integer, String> expected = TreeMap.of(1, "3");
        assertThat(actual).isEqualTo(expected);
    }

    // -- obsolete tests

    @Override
    public void shouldPreserveSingletonInstanceOnDeserialization() {
        // The empty TreeMap encapsulates a comparator and therefore cannot be a singleton
    }
}
