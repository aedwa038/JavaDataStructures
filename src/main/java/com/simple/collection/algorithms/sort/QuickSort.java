package com.simple.collection.algorithms.sort;

import com.simple.collection.utils.ShuffleUtils;
import com.simple.collection.utils.SortUtils;

/**
 * Created by akeemedwards on 11/2/17.
 */
public final class QuickSort {
    static final int CUT_OFF = 15;

    public static void sort(Comparable a[]) {
        if(!SortUtils.isSorted(a)) {
            ShuffleUtils.shuffle(a);
            sort(a, 0, a.length - 1);
        }
    }

    public static void sort(Comparable a[] , int low , int high) {
        if(high <=  low + CUT_OFF - 1) {
            InsertionSort.sort(a, low, high);
            return;
        }
        if(high <= low) return;
        int pivot = high;
        pivot = partition(a, low, high);
        sort(a, low, pivot - 1);
        sort(a, pivot + 1, high);


    }


    static int partition(Comparable[] ar, int low, int high) {

        int i = low ;
        int j = high + 1;
        Comparable value = ar[low];

        while (true) {
            while (SortUtils.isLess(ar[++i], value)) {
                if(i == high)
                    break;
            }

            while (SortUtils.isLess(value, ar[--j])) {
                if(j == low)
                    break;
            }
            if(i >= j)
                break;
            SortUtils.exchange(ar, i, j);
        }

        SortUtils.exchange(ar, low, j);

        return j;

    }
}
