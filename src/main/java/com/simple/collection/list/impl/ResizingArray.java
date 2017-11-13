package com.simple.collection.list.impl;

import com.simple.collection.AbstractList;
import com.simple.collection.algorithms.sort.HeapSort;
import com.simple.collection.list.ListADT;
import com.simple.collection.utils.ArrayUtils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by akeem on 10/3/17.
 */
public class ResizingArray<T> implements ListADT<T> {

    private T[] arrayList;
    private int size;


    public ResizingArray() {
        size = 0;
        arrayList = (T[]) new Object [10];
    }

    public ResizingArray(T[] arrayList, int size) {
        this.size = size;
        this.arrayList = arrayList;
    }

    public void push(T newObject) {
        if(full()) {
            resize(arrayList.length * 2);
        }
        arrayList[size++] = newObject;
    }

    public T pop() {
        if(isEmpty()) {
            throw new NoSuchElementException("List Over flow");
        }

        T toReturn = arrayList[--size];
        if(halfEmpty()) {
            resize(arrayList.length / 2);
        }
        return toReturn;
    }


    public T peek() {
        if(isEmpty()) {
             throw new NoSuchElementException("List Over flow");
        }
        return arrayList[size - 1];
    }

    public T get(int index) {
        if(size < 0 && size >= arrayList.length) {
            throw new IllegalArgumentException("invalid index");
        }
        return arrayList[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int indexOf(T object) {

        for (int i = 0; i < this.arrayList.length; i++) {
            if(object.equals(arrayList[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(T t) {
        if(isEmpty() || t == null) {
            throw new IllegalArgumentException("invalid parameters");
        }
        int index = indexOf(t);

        if(index == -1) {
            return false;
        }

        removeAt(index);
        return true;
    }



    @Override
    public void sort(Comparator<? super T> c) {

    }

    @Override
    public void clear() {
        this.size = 0;
    }

    @Override
    public <T> T[] toArray() {
        return null;
    }

    @Override
    public AbstractList<T> subList(int fromIndex, int toIndex) {
        if(fromIndex < 0 || toIndex > size || (fromIndex >  toIndex)) {
            return null;
        }

        T [] list = (T[]) new Object [10];
        int size = fromIndex - toIndex;
        for (int i = fromIndex; i < toIndex; i++) {
            list[i] = arrayList[i];
        }
        return new ResizingArray<T>(list, size);
    }

    void resize(int newLength) {
        T newT[] = (T[]) new Object[ newLength];
        copy(arrayList, newT);
        arrayList = newT;
    }

    void copy(T[] t, T[] newT ) {
        int smaller = t.length < newT.length ? t.length : newT.length;
        for (int i = 0; i < smaller; i++) {
            newT[i] = t[i];
        }
    }

    boolean halfEmpty() {
        return (( size() * 4) < arrayList.length);
    }

    boolean full() {
        return (size == arrayList.length);
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    @Override
    public void removeAt(int index) {
        if(size <= 0 || index >= size()) {
            throw new IllegalArgumentException("invalid index");
        }
        for (int i = index + 1; i < size;) {
            arrayList[index] = arrayList[i];
            index++;
            i++;
        }

        arrayList[--size] = null;
        if(halfEmpty()) {
            resize(arrayList.length / 2);
        }
    }

    class ArrayIterator implements Iterator<T> {
        int current = 0;
        @Override
        public void remove() {

        }

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public T next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            return arrayList[current++];
        }
    }
}
