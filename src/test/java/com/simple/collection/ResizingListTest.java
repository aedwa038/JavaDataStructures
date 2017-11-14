package com.simple.collection;

import com.simple.collection.list.impl.ResizingArray;
import com.simple.collection.list.impl.ResizingList;
import com.simple.collection.list.ListADT;
import com.simple.collection.utils.ArrayUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

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
        Assert.assertEquals(0, stringList.size());
        stringList.push("Hello");
        Assert.assertEquals(1, stringList.size());
        Assert.assertEquals("Hello", stringList.get(0));
        stringList.push("World");
        Assert.assertEquals(2, stringList.size());
        Assert.assertEquals("World", stringList.get(1));
        stringList.push("World2");
        Assert.assertEquals(3, stringList.size());

        Assert.assertEquals(stringList.indexOf("Hello") , 0);
        Assert.assertEquals(stringList.indexOf("World") , 1);
        Assert.assertEquals(stringList.indexOf("World2") , 2);
        Assert.assertEquals(stringList.indexOf("World3") , -1);


    }

    @Test
    public void isEmptyTest() {
        Assert.assertTrue(intList.isEmpty());
        intList.push(10);
        Assert.assertTrue(!intList.isEmpty());


    }

    @Test
    public void getTest() {
        Assert.assertEquals(0, stringList.size());
        stringList.push("Hello");
        Assert.assertEquals(1, stringList.size());
        Assert.assertEquals("Hello", stringList.get(0));

    }

    @Test
    public void peekTest() {
        Assert.assertEquals(0, stringList.size());
        stringList.push("Hello");
        Assert.assertEquals(1, stringList.size());
        Assert.assertEquals("Hello", stringList.peek());
    }

    @Test
    public void popTest() {
        Assert.assertEquals(0, stringList.size());
        stringList.push("Hello");
        Assert.assertEquals(1, stringList.size());
        Assert.assertEquals("Hello", stringList.get(0));
        stringList.push("World");
        Assert.assertEquals(2, stringList.size());
        Assert.assertEquals("World", stringList.get(1));
        stringList.push("World2");
        Assert.assertEquals(3, stringList.size());

        String s = stringList.pop();
        Assert.assertEquals("Hello", s);
        Assert.assertEquals(2, stringList.size());


    }

    @Test
    public void popAllTest() {
        Assert.assertEquals(0, stringList.size());
        stringList.push("Hello");
        Assert.assertEquals(1, stringList.size());
        Assert.assertEquals("Hello", stringList.get(0));
        stringList.push("World");
        Assert.assertEquals(2, stringList.size());
        Assert.assertEquals("World", stringList.get(1));
        stringList.push("World2");
        Assert.assertEquals(3, stringList.size());

        String s = stringList.pop();
        Assert.assertEquals("Hello", s);
        Assert.assertEquals(2, stringList.size());
        s = stringList.pop();
        Assert.assertEquals("World", s);
        Assert.assertEquals(1, stringList.size());
        s = stringList.pop();
        Assert.assertEquals("World2", s);
        Assert.assertEquals(0, stringList.size());


    }
    @Test
    public void removeIndexTest() {
        Assert.assertEquals(0, stringList.size());
        stringList.push("Hello");
        Assert.assertEquals(1, stringList.size());
        Assert.assertEquals("Hello", stringList.get(0));
        stringList.push("World");
        Assert.assertEquals(2, stringList.size());
        Assert.assertEquals("World", stringList.get(1));
        stringList.push("World2");
        Assert.assertEquals(3, stringList.size());

        Assert.assertEquals(stringList.indexOf("Hello") , 0);
        Assert.assertEquals(stringList.indexOf("World") , 1);
        Assert.assertEquals(stringList.indexOf("World2") , 2);

        stringList.removeAt(0);
        Assert.assertTrue(stringList.size() == 2);
        ArrayUtils.show(stringList);


    }

    @Test
    public void removeIndexEndTest() {
        Assert.assertEquals(0, stringList.size());
        stringList.push("Hello");
        Assert.assertEquals(1, stringList.size());
        Assert.assertEquals("Hello", stringList.get(0));
        stringList.push("World");
        Assert.assertEquals(2, stringList.size());
        Assert.assertEquals("World", stringList.get(1));
        stringList.push("World2");
        Assert.assertEquals(3, stringList.size());

        Assert.assertEquals(stringList.indexOf("Hello") , 0);
        Assert.assertEquals(stringList.indexOf("World") , 1);
        Assert.assertEquals(stringList.indexOf("World2") , 2);

        stringList.removeAt(2);
        Assert.assertTrue(stringList.size() == 2);
        ArrayUtils.show(stringList);


    }

    @Test
    public void removeIndexMiddleTest() {
        Assert.assertEquals(0, stringList.size());
        stringList.push("Hello");
        Assert.assertEquals(1, stringList.size());
        Assert.assertEquals("Hello", stringList.get(0));
        stringList.push("World");
        Assert.assertEquals(2, stringList.size());
        Assert.assertEquals("World", stringList.get(1));
        stringList.push("World2");
        Assert.assertEquals(3, stringList.size());

        Assert.assertEquals(stringList.indexOf("Hello") , 0);
        Assert.assertEquals(stringList.indexOf("World") , 1);
        Assert.assertEquals(stringList.indexOf("World2") , 2);

        stringList.removeAt(1);
        Assert.assertTrue(stringList.size() == 2);
        ArrayUtils.show(stringList);



    }

    @Test
    public void removeElement() {
        Assert.assertEquals(0, stringList.size());
        stringList.push("Hello");
        Assert.assertEquals(1, stringList.size());
        Assert.assertEquals("Hello", stringList.get(0));
        stringList.push("World");
        Assert.assertEquals(2, stringList.size());
        Assert.assertEquals("World", stringList.get(1));
        stringList.push("World2");
        Assert.assertEquals(3, stringList.size());

        Assert.assertEquals(stringList.indexOf("Hello") , 0);
        Assert.assertEquals(stringList.indexOf("World") , 1);
        Assert.assertEquals(stringList.indexOf("World2") , 2);

        stringList.remove("Hello");
        Assert.assertTrue(stringList.size() == 2);
        ArrayUtils.show(stringList);
    }

    @Test
    public void removeMiddleElement() {
        Assert.assertEquals(0, stringList.size());
        stringList.push("Hello");
        Assert.assertEquals(1, stringList.size());
        Assert.assertEquals("Hello", stringList.get(0));
        stringList.push("World");
        Assert.assertEquals(2, stringList.size());
        Assert.assertEquals("World", stringList.get(1));
        stringList.push("World2");
        Assert.assertEquals(3, stringList.size());

        Assert.assertEquals(stringList.indexOf("Hello") , 0);
        Assert.assertEquals(stringList.indexOf("World") , 1);
        Assert.assertEquals(stringList.indexOf("World2") , 2);

        boolean removed  = stringList.remove("World");
        Assert.assertTrue(removed);
        Assert.assertTrue(stringList.size() == 2);
        ArrayUtils.show(stringList);
    }

    @Test
    public void removeNoElement() {
        Assert.assertEquals(0, stringList.size());
        stringList.push("Hello");
        Assert.assertEquals(1, stringList.size());
        Assert.assertEquals("Hello", stringList.get(0));
        stringList.push("World");
        Assert.assertEquals(2, stringList.size());
        Assert.assertEquals("World", stringList.get(1));
        stringList.push("World2");
        Assert.assertEquals(3, stringList.size());

        Assert.assertEquals(stringList.indexOf("Hello") , 0);
        Assert.assertEquals(stringList.indexOf("World") , 1);
        Assert.assertEquals(stringList.indexOf("World2") , 2);

        boolean removed = stringList.remove("World3");
        Assert.assertFalse(removed);
        Assert.assertTrue(stringList.size() == 3);
        ArrayUtils.show(stringList);
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
    public void popIntegerTest() {

        for (int i = 0; i < 100; i++) {
            intList.push(i);
        }

        Assert.assertEquals(100, intList.size());


        for (int i = 0; i < 100; i++) {
            Assert.assertEquals(new Integer(i), intList.get(i));
        }

        IntStream.range(0, intList.size()).forEach(value -> intList.pop());

        Assert.assertEquals(0, intList.size());


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
