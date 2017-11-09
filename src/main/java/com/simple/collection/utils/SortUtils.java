package com.simple.collection.utils;

import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Created by akeemedwards on 10/31/17.
 */
public class SortUtils {

    public static boolean isLess(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static <Key> void exchange(Key [] array, int i , int j) {
        Key temp = array[i];
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

    public static boolean isReversedSorted(Comparable [] a) {

        for (int i = 0; i < a.length - 1; i++) {
            if(!isLess(a[i + 1], a[i])) {
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

    public static <Key> void swim(Key[] a, int j, Comparator keyComparator) {
        while(j > 1 && isLess(a, j / 2, j, keyComparator)) {
            exchange(a, j, j / 2);
            j = j / 2;
        }
    }

    public static <Key> void sink(Key[] a, int j,int size, Comparator keyComparator) {
        while (2 * j <= size) {
            int left = 2 * j;
            int right = 2 * j + 1;
            int largest =  j;
            if(left <= size && isLess(a, j, left, keyComparator)) {
                largest = left;
            }

            if(right <= size && isLess(a, largest, right, keyComparator)) {
                largest = right;
            }

            if(largest == j) {
                break;
            }

            exchange(a, largest, j);
            j = largest;
        }

    }

    public static <Key> boolean isLess(Key[] a,int i, int j, Comparator keyComparator) {
        return keyComparator.compare(a[i], a[j]) < 0;

    }
}
