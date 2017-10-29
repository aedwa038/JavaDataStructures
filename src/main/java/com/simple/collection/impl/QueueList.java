package com.simple.collection.impl;


import com.simple.collection.AbstractList;
import com.simple.collection.ListADT;
import com.simple.collection.Queue;

import java.util.Comparator;

/**
 * Created by akeem on 10/5/17.
 *
 * @param <T> the type parameter
 */
public class QueueList<T> implements Queue<T> {

    /**
     * The List.
     */
    ListADT<T> list = new ResizingList<T>();

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T peek() {
        return list.peek();
    }


    @Override
    public T pop() {
        return list.pop();
    }


    @Override
    public void push(T t) {
        list.push(t);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public <T1> T1[] toArray() {
        return null;
    }


    @Override
    public T poll() {
        return list.pop();
    }

    @Override
    public void offer(T t) {
        list.push(t);
    }
}
