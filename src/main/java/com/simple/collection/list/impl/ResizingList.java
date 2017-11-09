package com.simple.collection.list.impl;

import com.simple.collection.AbstractList;
import com.simple.collection.list.ListADT;

import java.util.Comparator;

/**
 * Created by akeem on 10/5/17.
 *
 * @param <T> the type parameter
 */
public class ResizingList <T> implements ListADT <T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    /**
     * Instantiates a new Resizing list.
     */
    public ResizingList() {
        head = null;
        tail = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(T t) {
        if(size == 0) {
            return -1;
        }

        Node<T> current = head;
        int index = 0;
        current = current.getNext();
        while ((!current.getData().equals(t)) || current != null) {
            current = current.getNext();
            index++;
        }
        if(current == null) {
            return -1;
        }
        return index;
    }

    @Override
    public T peek() {
        return head.data;
    }

    @Override
    public T pop() {
        if(head.next == tail.next) {
            T data = head.data;
            head = tail = null;
            return data;
        }

        Node<T> newHead = head.getNext();
        T data = head.getData();
        head.setNext(null);
        head = newHead;
        size--;
        return data;

    }

    @Override
    public T get(int index) {
        if(index > size()) {
            return null;
        }
        int i = 0;
        Node<T> current = head;

        while ((i !=  index) && current != null) {
            current = current.getNext();
            i++;
        }
        if(current == null) {
            return null;
        }

        return current.getData();
    }

    @Override
    public void push(T t) {
        Node<T> node = new Node<>();
        node.setData(t);
        node.setNext(null);
        if(head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(T t) {
        return false;
    }

    @Override
    public void sort(Comparator<? super T> c) {

    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public <T1> T1[] toArray() {
        return null;
    }

    @Override
    public AbstractList<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public void remove(int index) {

    }

    /**
     * The type Node.
     *
     * @param <T> the type parameter
     */
    class Node<T> {

        /**
         * The Data.
         */
        T data;
        /**
         * The Next.
         */
        Node<T> next;


        /**
         * Instantiates a new Node.
         */
        public Node() {
            next = null;
        }

        /**
         * Sets data.
         *
         * @param data the data
         */
        public void setData(T data) {
            this.data = data;
        }

        /**
         * Sets next.
         *
         * @param next the next
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }

        /**
         * Gets data.
         *
         * @return the data
         */
        public T getData() {
            return data;
        }

        /**
         * Gets next.
         *
         * @return the next
         */
        public Node<T> getNext() {
            return next;
        }
    }
}
