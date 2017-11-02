package com.simple.collection.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Created by akeemedwards on 10/31/17.
 */
public class SortUtilsTest {
    @Test
    public void isLesstest() {
        Integer a = 44;
        Integer b = 45;

        Assert.assertTrue(SortUtils.isLess(a, b));
        Assert.assertFalse(SortUtils.isLess(b, a));
    }

    @Test
    public void showTest() {
        Integer[] integers = new Integer[]{1, 2,3, 4,5, 6, 7};

        SortUtils.show(integers);
    }

    @Test
    public void isSortedTest() {
        Integer[] integers = new Integer[100];

        IntStream.range(0, integers.length).forEach(value -> integers[value] = value);
        Assert.assertTrue(SortUtils.isSorted(integers));

    }

    @Test
    public void isSortedFalseTest() {
        Integer[] integers = new Integer[]{7,6,5,4,3,2,1};
        Assert.assertFalse(SortUtils.isSorted(integers));

    }

    @Test
    public void exchangeTest() {
            Integer[] integers = new Integer[100];

            IntStream.range(0, integers.length).forEach(value -> integers[value] = value);
            Assert.assertTrue(SortUtils.isSorted(integers));

            SortUtils.exchange(integers, 0 , integers.length - 1);
            Assert.assertFalse(SortUtils.isSorted(integers));
            Assert.assertEquals( Integer.valueOf(99) , integers[0]);
    }
}
