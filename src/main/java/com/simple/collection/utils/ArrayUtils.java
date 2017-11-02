package com.simple.collection.utils;

/**
 * Created by akeemedwards on 10/31/17.
 */
public class ArrayUtils {

    public void sort(Comparable [] a) {
        InsertionSort.sort(a);
    }

    public void shuffle(Comparable[] a) {
        ShuffleUtils.shuffle(a);
    }


}
