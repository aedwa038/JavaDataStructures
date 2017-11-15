package com.simple.collection.stack.impl;

import com.simple.collection.list.ListADT;
import com.simple.collection.list.impl.ResizingList;
import com.simple.collection.stack.StackADT;

/**
 * Created by akeem on 10/5/17.
 */
public class StackArrayImpl<T> implements StackADT<T> {

    private ListADT<T> listADT;


    public StackArrayImpl() {
        listADT = new ResizingList<T>();
    }

    @Override
    public boolean isEmpty() {
        return listADT.isEmpty();
    }

    @Override
    public T peek() {
        return listADT.get(listADT.size() - 1);
    }

    @Override
    public T pop() {
        T t = listADT.get(listADT.size() - 1);
        listADT.removeAt(listADT.size() - 1);
        return t;
    }

    @Override
    public void push(T t) {
        listADT.push(t);
    }

    @Override
    public int size() {
        return listADT.size();
    }

    @Override
    public void clear() {
        listADT.clear();
    }

    @Override
    public <T1> T1[] toArray() {
        return null;
    }

}
