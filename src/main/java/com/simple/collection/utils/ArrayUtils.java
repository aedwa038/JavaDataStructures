package com.simple.collection.utils;

import com.simple.collection.algorithms.sort.InsertionSort;
import com.simple.collection.list.ListADT;

import java.util.stream.IntStream;

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

    public static void show(Comparable []a ) {
        IntStream.range(0, a.length).forEach(value -> System.out.print(a[value] + " "));
        System.out.println();
    }

    public static  <Key>  void show(Key []a ) {
        IntStream.range(0, a.length).forEach(value -> System.out.print(a[value] + " "));
        System.out.println();
    }

    public static <T> void  show(ListADT<T> list) {
        list.forEach(t -> System.out.print(t + " "));
        System.out.println();
    }


}
