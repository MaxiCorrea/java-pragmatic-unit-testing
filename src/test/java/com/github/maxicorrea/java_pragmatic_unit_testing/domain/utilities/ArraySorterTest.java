package com.github.maxicorrea.java_pragmatic_unit_testing.domain.utilities;

import java.util.Arrays;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

public class ArraySorterTest {

    ArraySorter sorter = new ArraySorter();

    @Property
    boolean returnsSameArrayWhenAlreadySorted(@ForAll int[] array) {
        Arrays.sort(array);
        var expected = array.clone();
        sorter.insertionSort(array);
        return Arrays.equals(expected, array);
    }

    @Property
    boolean returnsSameArrayWhenAllSameElements(@ForAll int element) {
        var array = new int[12];
        Arrays.fill(array, element);
        var expected = array.clone();
        sorter.insertionSort(array);
        return Arrays.equals(expected, array);
    }

    @Property
    boolean sortsAscendingWhenRandomUnsortedArray(@ForAll int[] array) {
        var expected = array.clone();
        Arrays.sort(expected);
        sorter.insertionSort(array);
        return Arrays.equals(expected, array);
    }

}
