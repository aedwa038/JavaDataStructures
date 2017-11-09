package com.simple.collection.algorithms.sort;

import com.simple.collection.utils.SortUtils;

/**
 * Created by akeemedwards on 10/31/17.
 */
 public class InsertionSort {

    public static void sort(Comparable a[]) {
        if(!SortUtils.isSorted(a)) {
            sort(a, 0, a.length - 1);
        }
    }

    public static void sort(Comparable a[] , int low , int high){
        for (int i = low ; i <= high; i++) {
            for (int j = i; j > low && SortUtils.isLess(a[j], a[j - 1]); j--) {
                SortUtils.exchange(a, j, j - 1);
            }
        }

    }


}
