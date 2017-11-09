package com.simple.collection.queue;

import com.simple.collection.utils.SortUtils;

import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Created by akeemedwards on 11/6/17.
 */
public class MaxPQ<Key> {
    private Key[] a;
    private int size;
    private Comparator<Key> keyComparator;

    public MaxPQ(int max, Comparator<Key> keyComparator) {
        a = (Key[]) new Object[max + 1];
        size = 0;
        this.keyComparator = keyComparator;
    }



    public void insert(Key newKey) {
        if((size) ==(a.length - 1)) {
            throw new ArrayIndexOutOfBoundsException("out of bounds");
        }
        a[++size] = newKey;
        SortUtils.swim(a, size, keyComparator);
    }

    public Key max() {
        if(isEmpty()) {
            throw new NoSuchElementException("Underflow in priority queue");
        }
        Key value =  a[1];
        SortUtils.exchange(a, 1, size);
        size--;
        SortUtils.sink(a, 1, size, keyComparator);
        a[size + 1] = null;
        return value;

    }



    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }


}
