package com.simple.collection;

import com.simple.collection.list.impl.ResizingArray;
import com.simple.collection.queue.MaxPQ;
import com.simple.collection.utils.ArrayUtils;
import com.simple.collection.utils.SortUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

/**
 * Created by akeemedwards on 11/8/17.
 */
public class MaxPQTest {

    @Test
    public  void testInsert() {
        MaxPQ<Integer> integerMaxPQ = new MaxPQ<>(10, (o1, o2) -> o1.compareTo(o2));

        IntStream.range(0, 10).forEach(value -> integerMaxPQ.insert(value));
        System.out.println(integerMaxPQ.size());
        Assert.assertTrue(integerMaxPQ.size() == 10);

    }


    @Test
    public  void testMax() {
        MaxPQ<Integer> integerMaxPQ = new MaxPQ<>(10, (o1, o2) -> o1.compareTo(o2));

        IntStream.range(0, 10).forEach(value -> integerMaxPQ.insert(value));
       // System.out.println(integerMaxPQ.size());
        Assert.assertTrue(integerMaxPQ.size() == 10);


        for (int i = 9; i >= 0; i--) {
            Assert.assertEquals(Integer.valueOf(i), integerMaxPQ.max());
        }

    }


    @Test
    public  void testMaxReverse() {
        MaxPQ<Integer> integerMaxPQ = new MaxPQ<>(10, (o1, o2) -> o2.compareTo(o1));

        IntStream.range(0, 10).forEach(value -> integerMaxPQ.insert(value));
        // System.out.println(integerMaxPQ.size());
        Assert.assertTrue(integerMaxPQ.size() == 10);


        for (int i = 0; i <= 9; i++) {
            Assert.assertEquals(Integer.valueOf(i), integerMaxPQ.max());
        }

    }


    @Test
    public  void testRandom() {

            Integer[] a = new Integer[]{7, 14, 1, 11, 3, 6, 12, 0, 4, 5, 2, 9, 13, 8, 10 };
        ArrayUtils.show(a);
            MaxPQ<Integer> integerMaxPQ = new MaxPQ<>(a.length, (o1, o2) -> o1.compareTo(o2));

            Arrays.stream(a).forEach(integer -> integerMaxPQ.insert(integer));
            IntStream.range(0, a.length).forEach(value -> a[value] = integerMaxPQ.max());
        ArrayUtils.show(a);

            Assert.assertTrue(SortUtils.isReversedSorted(a));


    }


    @Test
    public  void testIterator() {

        Integer[] a = new Integer[]{7, 14, 1, 11, 3, 6, 12, 0, 4, 5, 2, 9, 13, 8, 10 };
        ArrayUtils.show(a);
        MaxPQ<Integer> integerMaxPQ = new MaxPQ<>(a.length, (o1, o2) -> o1.compareTo(o2));

        Arrays.stream(a).forEach(integer -> integerMaxPQ.insert(integer));

        Iterator<Integer> integerIterator = integerMaxPQ.iterator();
        Assert.assertTrue(integerIterator.hasNext());
        Assert.assertEquals(new Integer(14) , integerIterator.next());



    }

    @Test
    public  void testForeach() {

        Integer[] a = new Integer[]{7, 14, 1, 11, 3, 6, 12, 0, 4, 5, 2, 9, 13, 8, 10 };
        ArrayUtils.show(a);
        MaxPQ<Integer> integerMaxPQ = new MaxPQ<>(a.length, (o1, o2) -> o1.compareTo(o2));

        Arrays.stream(a).forEach(integer -> integerMaxPQ.insert(integer));

        ResizingArray<Integer> integerResizingArray = new ResizingArray<>();
        for (Integer integer : integerMaxPQ) {
            integerResizingArray.push(integer);
        }

        Assert.assertEquals(integerResizingArray.size(), integerMaxPQ.size());



    }
}
