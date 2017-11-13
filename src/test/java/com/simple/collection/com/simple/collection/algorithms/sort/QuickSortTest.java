package com.simple.collection.com.simple.collection.algorithms.sort;

import com.simple.collection.algorithms.sort.QuickSort;
import com.simple.collection.utils.ArrayUtils;
import com.simple.collection.utils.ShuffleUtils;
import com.simple.collection.utils.SortUtils;
import com.simple.collection.utils.StopWatch;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Created by akeemedwards on 11/2/17.
 */
public class QuickSortTest {

    @Test
    public void sortTest1() {
        Integer[] a = new Integer[]{1,2,3,4,5,6,7,8,9};
        QuickSort.sort(a);
        Assert.assertTrue(SortUtils.isSorted(a));

    }

    @Test
    public void sortTest() {
        Integer[] a = new Integer[]{2,1,4,3,6,5,9,8,7};
        QuickSort.sort(a);
        ArrayUtils.show(a);
        Assert.assertTrue(SortUtils.isSorted(a));

    }

    @Test
    public void sortTest2() {
        Integer[] a = new Integer[]{9,8,7,6,5,4,3,2,1};
        QuickSort.sort(a);
        ArrayUtils.show(a);
        Assert.assertTrue(SortUtils.isSorted(a));

    }


    @Test
    public void sortTest3() {
        Integer[] a = new Integer[100];
        IntStream.range(0, a.length).forEach(value -> a[value] = value);
        ShuffleUtils.shuffle(a);
        ArrayUtils.show(a);
        QuickSort.sort(a);
        ArrayUtils.show(a);
        Assert.assertTrue(SortUtils.isSorted(a));

    }

    @Test
    public void sortLargeTest() {
        Integer[] a = new Integer[10000];
        IntStream.range(0, a.length).forEach(value -> a[value] = value);
        ShuffleUtils.shuffle(a);

        ArrayUtils.show(a);
        StopWatch stopWatch = new StopWatch();
        QuickSort.sort(a);
        stopWatch.log();
        ArrayUtils.show(a);
        Assert.assertTrue(SortUtils.isSorted(a));

    }


    @Test
    public void sortVeryLargeTest() {
        Integer[] a = new Integer[100000];
        IntStream.range(0, a.length).forEach(value -> a[value] = value);
        ShuffleUtils.shuffle(a);

        //ArrayUtils.show(a);
        StopWatch stopWatch = new StopWatch();
        QuickSort.sort(a);
        stopWatch.log();
        //ArrayUtils.show(a);
        Assert.assertTrue(SortUtils.isSorted(a));

    }


    @Test
    public void sortVeryVeryLargeTest() {
        Integer[] a = new Integer[1000000];
        IntStream.range(0, a.length).forEach(value -> a[value] = value);
        ShuffleUtils.shuffle(a);

        //ArrayUtils.show(a);
        StopWatch stopWatch = new StopWatch();
        QuickSort.sort(a);
        stopWatch.log();
        //ArrayUtils.show(a);
        Assert.assertTrue(SortUtils.isSorted(a));

    }
}
