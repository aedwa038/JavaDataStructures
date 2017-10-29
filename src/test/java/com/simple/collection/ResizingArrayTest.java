package com.simple.collection;

import com.simple.collection.impl.ResizingArray;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

    }

    @Test
    public void removeElement() {

    }

}
