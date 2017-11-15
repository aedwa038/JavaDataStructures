package com.simple.collection;

import com.simple.collection.list.impl.ResizingArray;
import com.simple.collection.stack.StackADT;
import com.simple.collection.stack.impl.StackArrayImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Created by akeemedwards on 11/14/17.
 */
public class StackArrayTest {

    StackADT<Integer> integerStackADT;
    StackADT<String> stringStackADT;

    @Before
    public void setUp() {
        integerStackADT = new StackArrayImpl<>();
        stringStackADT = new StackArrayImpl<>();
    }

    @After
    public void tearDown() {
        integerStackADT = new StackArrayImpl<>();
        stringStackADT = new StackArrayImpl<>();
    }

    @Test
    public void pushTest() {
        Assert.assertTrue(stringStackADT.isEmpty());
        stringStackADT.push("Hello");
        Assert.assertTrue(!stringStackADT.isEmpty());

    }

    @Test
    public void pushTest2() {
        Assert.assertTrue(integerStackADT.isEmpty());
        IntStream.range(0, 100).forEach(value -> integerStackADT.push(value));
        Assert.assertTrue(!integerStackADT.isEmpty());
        Assert.assertEquals(100, integerStackADT.size());
    }

    @Test
    public void popTest() {
        Assert.assertTrue(integerStackADT.isEmpty());
        IntStream.range(0, 100).forEach(value -> integerStackADT.push(value));
        Assert.assertTrue(!integerStackADT.isEmpty());
        Assert.assertEquals(100, integerStackADT.size());

        IntStream.range(0, 100).forEach(value -> integerStackADT.pop());
        Assert.assertTrue(integerStackADT.isEmpty());
    }



    @Test
    public void popTest2() {
        Assert.assertTrue(stringStackADT.isEmpty());
        stringStackADT.push("Hello");
        Assert.assertTrue(!stringStackADT.isEmpty());
        String s = stringStackADT.pop();
        Assert.assertEquals("Hello", s);
        Assert.assertTrue(stringStackADT.isEmpty());
    }

    @Test
    public void popTest3() {
        Assert.assertTrue(integerStackADT.isEmpty());
        IntStream.range(0, 100).forEach(value -> integerStackADT.push(value));
        Assert.assertTrue(!integerStackADT.isEmpty());
        Assert.assertEquals(100, integerStackADT.size());

        for (int i = 99; i >= 0; i--) {
            Assert.assertEquals(new Integer(i), integerStackADT.pop());
        }
        Assert.assertTrue(integerStackADT.isEmpty());


    }

    @Test
    public void peekTest() {
        Assert.assertTrue(stringStackADT.isEmpty());
        stringStackADT.push("Hello");
        Assert.assertTrue(!stringStackADT.isEmpty());
        String s = stringStackADT.peek();
        Assert.assertEquals("Hello", s);
    }

    @Test
    public void peekTest2() {
        Assert.assertTrue(stringStackADT.isEmpty());
        stringStackADT.push("Hello");
        stringStackADT.push("World");
        Assert.assertTrue(!stringStackADT.isEmpty());
        String s = stringStackADT.peek();
        Assert.assertEquals("World", s);
    }

    @Test
    public void peekTest3() {
        Assert.assertTrue(integerStackADT.isEmpty());
        IntStream.range(0, 100).forEach(value -> integerStackADT.push(value));
        Assert.assertTrue(!integerStackADT.isEmpty());
        Assert.assertEquals(100, integerStackADT.size());

        for (int i = 99; i >= 0; i--) {
            Assert.assertEquals(new Integer(i), integerStackADT.peek());
            integerStackADT.pop();
        }
        Assert.assertTrue(integerStackADT.isEmpty());
    }

    @Test
    public void isEmptyTest() {
        Assert.assertTrue(stringStackADT.isEmpty());
        stringStackADT.push("Hello");
        Assert.assertTrue(!stringStackADT.isEmpty());
        stringStackADT.pop();
        Assert.assertTrue(stringStackADT.isEmpty());
        Assert.assertTrue(stringStackADT.isEmpty());

    }

    @Test
    public void sizeTest() {
        Assert.assertEquals(0, integerStackADT.size());
        integerStackADT.push(1);
        Assert.assertEquals(1, integerStackADT.size());
    }

    @Test
    public void clearTest() {
        Assert.assertTrue(stringStackADT.isEmpty());
        stringStackADT.push("Hello");
        Assert.assertTrue(!stringStackADT.isEmpty());
        stringStackADT.clear();
        Assert.assertTrue(stringStackADT.isEmpty());
        Assert.assertEquals(0, stringStackADT.size());

    }


    @Test
    public void clearTest2() {
        Assert.assertTrue(integerStackADT.isEmpty());
        IntStream.range(0, 100).forEach(value -> integerStackADT.push(value));
        Assert.assertTrue(!integerStackADT.isEmpty());
        Assert.assertEquals(100, integerStackADT.size());
        integerStackADT.clear();
        Assert.assertTrue(integerStackADT.isEmpty());
        Assert.assertEquals(0, integerStackADT.size());

    }
}
