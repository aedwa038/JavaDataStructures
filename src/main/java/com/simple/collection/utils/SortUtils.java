package com.simple.collection.utils;

import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Created by akeemedwards on 10/31/17.
 */
class SortUtils {

    public static boolean isLess(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exchange(Comparable [] array, int i , int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    public static void show(Comparable []a ) {
        IntStream.range(0, a.length).forEach(value -> System.out.print(a[value] + " "));
        System.out.println();
    }

    public static boolean isSorted(Comparable [] a) {

        for (int i = 0; i < a.length - 1; i++) {
            if(!isLess(a[i], a[i + 1])) {
                return false;
            }
        }
        return true;
    }

    static void copy(Comparable a[], Comparable[] aux, int low , int high) {
        for (int i = low; i <= high; i++) {
            aux[i] = a[i];
        }
    }
}
