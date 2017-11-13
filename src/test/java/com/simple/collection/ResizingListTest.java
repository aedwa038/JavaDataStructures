package com.simple.collection;

import com.simple.collection.list.impl.ResizingArray;
import com.simple.collection.list.impl.ResizingList;
import com.simple.collection.list.ListADT;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by akeem on 10/5/17.
 */
public class ResizingListTest {


    ListADT<String> stringList;
    ListADT<Integer> intList;

    @Before
    public void setUp() {
        stringList = new ResizingList<>();
        intList = new ResizingList<>();
    }

    @After
    public void tearDown() {
        intList = new ResizingArray<Integer>();
        stringList = new ResizingArray<String>();
    }

    @Test
    public void indexOfTest() {

    }

    @Test
    public void isEmptyTest() {

    }

    @Test
    public void getTest() {

    }

    @Test
    public void peekTest() {

    }

    @Test
    public void popTest() {

    }
    @Test
    public void removeIndexTest() {

    }

    @Test
    public void removeElement() {

    }

    @Test
    public void pushTest() {
        Assert.assertEquals(0, stringList.size());
        stringList.push("Hello");
        Assert.assertEquals(1, stringList.size());
        Assert.assertEquals("Hello", stringList.get(0));
        stringList.push("World");
        Assert.assertEquals(2, stringList.size());
        Assert.assertEquals("World", stringList.get(1));


    }


    @Test
    public void pushIntegerTest() {

        for (int i = 0; i < 100; i++) {
            intList.push(i);
        }

        Assert.assertEquals(100, intList.size());


        for (int i = 0; i < 100; i++) {
            Assert.assertEquals(new Integer(i), intList.get(i));
        }


    }

    @Test
    public void testforeach() {

        for (int i = 0; i < 100; i++) {
            intList.push(i);
        }

        Assert.assertEquals(100, intList.size());

        ListADT<Integer> listADT = new ResizingList<>();
        for (Integer integer : intList) {
            listADT.push(integer);
        }

        Assert.assertEquals(intList.size(), listADT.size());

    }

    @Test
    public void sizeTest() {
        Assert.assertTrue(intList.isEmpty());
        Assert.assertTrue(stringList.isEmpty());
        Assert.assertEquals(0, intList.size());
        Assert.assertEquals(0, stringList.size());
        intList.push(0);
        Assert.assertEquals(1, intList.size());
        stringList.push("Hello");
        Assert.assertFalse(stringList.isEmpty());
        Assert.assertEquals(1, stringList.size());

    }
}
