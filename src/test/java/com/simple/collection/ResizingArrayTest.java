package com.simple.collection;

import com.simple.collection.list.impl.ResizingArray;
import com.simple.collection.list.ListADT;
import com.simple.collection.utils.ArrayUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

/**
 * Created by akeem on 10/3/17.
 */
public class ResizingArrayTest {


    ListADT<Double> doubleArray;
    ListADT<Integer> intArray;
    ListADT<String> stringArray;

    @Before
    public void setUp() {
        doubleArray = new ResizingArray<Double>();
        intArray = new ResizingArray<Integer>();
        stringArray = new ResizingArray<String>();
    }

    @After
    public void tearDown() {
        doubleArray = new ResizingArray<Double>();
        intArray = new ResizingArray<Integer>();
        stringArray = new ResizingArray<String>();
    }

    @Test
    public void test_canCreateArraysOfDifferentTypes() {
        Assert.assertNotNull(doubleArray);
        Assert.assertNotNull(intArray);
        Assert.assertNotNull(stringArray);
    }

    @Test
    public void test_SizeShouldBeZeroForNewEmptyArray() {
        Assert.assertTrue(doubleArray.isEmpty());
        Assert.assertEquals(0, doubleArray.size());
        Assert.assertTrue(intArray.isEmpty());
        Assert.assertEquals(0, intArray.size());
        Assert.assertTrue(stringArray.isEmpty());
        Assert.assertEquals(0, stringArray.size());
    }

    @Test
    public void testPush() {
        Assert.assertNotNull(intArray);
        for (int i = 0; i < 100; i++) {
            intArray.push(i);
        }

        Assert.assertEquals(100, intArray.size());
    }

    @Test
    public void testPop() {
        Assert.assertNotNull(intArray);
        for (int i = 0; i < 100; i++) {
            intArray.push(i);
        }

        for (int i = 0; i < 50; i++) {
            intArray.pop();
        }

        Assert.assertEquals(50, intArray.size());
    }
    @Test(expected = NoSuchElementException.class)
    public void testPopEmpty() {
        intArray.pop();
    }
    @Test(expected =  NoSuchElementException.class)
    public void testPeekEmpty() {
        intArray.peek();
    }

    @Test
    public void testEmpty() {
        Assert.assertNotNull(intArray);
        intArray.push(5);

        Assert.assertEquals( 1, intArray.size());

        intArray.pop();
        Assert.assertEquals(0, intArray.size());
    }

    @Test
    public void test_SizeShouldBeEqualToNumberOfItemsAdded() {
        int n = 0;
        Assert.assertTrue(doubleArray.isEmpty());
        doubleArray.push(1.00);
        ++n;
        doubleArray.push(2.00);
        ++n;
        Assert.assertEquals(2, doubleArray.size());
        double number = 1.00;
        for(int i = 0; i < 20; i++) {
            ++n;
            number += i;
            doubleArray.push(number);
        }
        Assert.assertEquals(n, doubleArray.size());
        Assert.assertEquals((Double) number, doubleArray.peek());
    }

    @Test
    public void removeIndexTest() {
        Assert.assertNotNull(intArray);
        intArray.push(5);
        intArray.removeAt(0);
        Assert.assertTrue(intArray.isEmpty());

    }

    @Test
    public void removeIndexTest2() {
        Assert.assertNotNull(intArray);
        intArray.push(5);
        intArray.push(0);
        Assert.assertTrue(!intArray.isEmpty());
        Assert.assertEquals(2, intArray.size());
        intArray.remove(5);
        Assert.assertTrue(!intArray.isEmpty());
        Assert.assertEquals(1, intArray.size());
        Assert.assertEquals(new Integer(0), intArray.get(0));

    }

    @Test
    public void removeIndexTest3() {
        Assert.assertNotNull(intArray);
        intArray.push(5);
        intArray.push(0);
        Assert.assertTrue(!intArray.isEmpty());
        Assert.assertEquals(2, intArray.size());
        intArray.remove(0);
        Assert.assertTrue(!intArray.isEmpty());
        Assert.assertEquals(1, intArray.size());
        Assert.assertEquals(new Integer(5), intArray.get(0));

    }

    @Test
    public void removeIndexTest4() {
        Assert.assertNotNull(intArray);
        intArray.push(5);
        intArray.push(0);
        Assert.assertTrue(!intArray.isEmpty());
        Assert.assertEquals(2, intArray.size());
        intArray.removeAt(0);
        Assert.assertTrue(!intArray.isEmpty());
        Assert.assertEquals(1, intArray.size());
        Assert.assertEquals(new Integer(0), intArray.get(0));

    }

    @Test
    public void removeIndexTest5() {
        Assert.assertNotNull(intArray);
        intArray.push(5);
        intArray.push(0);
        Assert.assertTrue(!intArray.isEmpty());
        Assert.assertEquals(2, intArray.size());
        intArray.removeAt(1);
        Assert.assertTrue(!intArray.isEmpty());
        Assert.assertEquals(1, intArray.size());
        Assert.assertEquals(new Integer(5), intArray.get(0));

    }

    @Test(expected = IllegalArgumentException.class)
    public void removeIndexTest6() {
        Assert.assertNotNull(intArray);
        intArray.push(5);
        intArray.push(0);
        Assert.assertTrue(!intArray.isEmpty());
        Assert.assertEquals(2, intArray.size());
        intArray.removeAt(2);
        Assert.assertTrue(!intArray.isEmpty());
        Assert.assertEquals(1, intArray.size());
        Assert.assertEquals(new Integer(5), intArray.get(0));

    }

    @Test
    public void removeSeveral() {
        IntStream.range(0, 20).forEach(value -> intArray.push(value));
        ArrayUtils.show(intArray);
        Assert.assertTrue(!intArray.isEmpty());
        Assert.assertEquals(20 , intArray.size());
        IntStream.range(0, 10).forEach(value -> intArray.removeAt(value));
        Assert.assertTrue(!intArray.isEmpty());
        Assert.assertEquals(10 , intArray.size());
        ArrayUtils.show(intArray);

    }

    @Test
    public void removeSeveral2() {
        IntStream.range(0, 20).forEach(value -> intArray.push(value));
        ArrayUtils.show(intArray);
        Assert.assertTrue(!intArray.isEmpty());
        Assert.assertEquals(20 , intArray.size());
        IntStream.range(0, 10).forEach(value -> intArray.removeAt(0));
        Assert.assertTrue(!intArray.isEmpty());
        Assert.assertEquals(10 , intArray.size());
        ArrayUtils.show(intArray);

    }

    @Test
    public void indexOftest() {
        IntStream.range(0, 20).forEach(value -> intArray.push(value));
        IntStream.range(0, 20).forEach(value -> {
            Assert.assertEquals(value, intArray.indexOf(value));
        });
    }

    @Test
    public void indexOftest2() {
        IntStream.range(0, 20).forEach(value -> intArray.push(value));
        Assert.assertEquals(19, intArray.indexOf(19));
        intArray.push(20);
        Assert.assertEquals(19, intArray.indexOf(19));
        intArray.removeAt(10);
        Assert.assertEquals(18, intArray.indexOf(19));
        intArray.removeAt(18);
        Assert.assertEquals(-1 , intArray.indexOf(19));
        Assert.assertFalse(intArray.remove(19));

    }


    @Test
    public void testIterator() {

        for (int i = 0; i < 100; i++) {
            intArray.push(i);
        }
        ListADT<Integer> integers = new ResizingArray<>();
        for (Integer integer : intArray) {
            integers.push(integer);
        }

        Assert.assertEquals(integers.size(), intArray.size());


    }

}
