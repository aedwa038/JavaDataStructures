package com.simple.collection.stack;

import com.simple.collection.AbstractList;

/**
 * Created by akeem on 10/5/17.
 */
public interface StackADT <T> {

    /**
     * Look at the last item in the list but do not remove it.
     * @return
     */
    T peek();
    /**
     * Remove the last item in the list and return it.
     * @return
     */
    T pop();

    /**
     * Add a new item to the end of the list.
     * @param t
     */
    void push(T t);
    /**
     * Get the size of the list.
     * @return
     */
    int size();

    void clear();

    boolean isEmpty();

    <T1> T1[] toArray();


}
