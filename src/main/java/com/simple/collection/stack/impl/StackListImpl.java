package com.simple.collection.stack.impl;

import com.simple.collection.list.ListADT;
import com.simple.collection.list.impl.ResizingList;
import com.simple.collection.stack.StackADT;

/**
 * Created by akeem on 10/5/17.
 *
 * @param <T> the type parameter
 */
public class StackListImpl <T> implements StackADT<T> {

    /**
     * The List.
     */
    ListADT<T> list = new ResizingList<>();

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public T peek() {
        return list.get(list.size() - 1);
    }

    @Override
    public T pop() {
        T t = list.get(list.size() - 1);
         list.removeAt(list.size() - 1);
        return t;
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

}
