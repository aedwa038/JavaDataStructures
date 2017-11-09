package com.simple.collection.algorithms.sort;

import com.simple.collection.utils.SortUtils;

/**
 * Created by akeemedwards on 11/1/17.
 */
public class MergeSort {

    static Comparable[] aux;

    public static void sort(Comparable a[]) {
        if(!SortUtils.isSorted(a)) {
            aux = new Comparable[a.length];
            sort(a, 0, a.length - 1);
        }
    }

    public static void sort(Comparable a[] , int low , int high) {
        if(high <= low) return;
        int mid = low + (high - low )/ 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, high, mid);

    }

    static void merge(Comparable a[] , int low , int high, int mid) {

        int i = low;
        int j = mid + 1;
        SortUtils.copy(a, aux, low, high);
        for (int k = low; k <= high; k++) {
            if(i >  mid) {
                a[k] = aux[j];
                j++;
            }
            else if(j > high) {
                a[k] = aux[i];
                i++;
            }
            else if(SortUtils.isLess(aux[i], aux[j])) {
                a[k] = aux[i];
                i++;
            } else {
                a[k] = aux[j];
                j++;
            }
        }


    }

}
