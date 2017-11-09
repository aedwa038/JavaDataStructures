package com.simple.collection.algorithms.sort;

import com.simple.collection.utils.SortUtils;

import java.util.Comparator;

/**
 * Created by akeemedwards on 11/8/17.
 */
public final class HeapSort {

    public static <Key extends Comparable> void sort(Comparable a[], Comparator<Key> keyComparator) {
        if(SortUtils.isSorted(a)) {
           return;
        }
        int size = a.length;
        for (int i = size / 2; i >= 1 ; i--) {
            sink(a, i, size, keyComparator);
        }

        while (size > 1) {
            SortUtils.exchange(a, 0, size - 1);
            size--;
            sink(a, 1, size, keyComparator);
        }

    }

    public static  void sink(Comparable[] a, int j,int size, Comparator keyComparator) {
        while (2 * j <= size) {
            int left = 2 * j;
            int right = 2 * j + 1;
            int largest =  j;
            if(left <= size && SortUtils.isLess(a, j - 1, left - 1, keyComparator)) {
                largest = left;
            }

            if(right <= size && SortUtils.isLess(a, largest - 1, right -1 , keyComparator)) {
                largest = right;
            }

            if(largest == j) {
                break;
            }

            SortUtils.exchange(a, largest - 1, j - 1);
            j = largest;
        }

    }

}
