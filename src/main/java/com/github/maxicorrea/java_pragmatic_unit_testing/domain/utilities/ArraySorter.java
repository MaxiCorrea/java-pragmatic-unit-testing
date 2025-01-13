package com.github.maxicorrea.java_pragmatic_unit_testing.domain.utilities;

public class ArraySorter {

    public void insertionSort(
            final int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = key;
        }
    }
}
