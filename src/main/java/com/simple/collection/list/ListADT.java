package com.simple.collection.list;

import com.simple.collection.AbstractList;

import java.util.Comparator;

/**
 * Created by akeem on 10/3/17.
 * <p>
 * This interface represents a List as an Abstract Data Type.
 *
 * @param <T> the type parameter
 */
public interface ListADT< T > extends AbstractList<T> {
    /**
     * Get the index of an item in the list.
     *
     * @param t the t
     * @return int
     */
    int indexOf(T t);

    /**
     * Get the item at index i in the list.
     *
     * @param index the index
     * @return t
     */
    T get(int index);

    /**
     * Remove boolean.
     *
     * @param t the t
     * @return the boolean
     */
    boolean remove(T t);

    /**
     * Remove.
     *
     * @param index the index
     */
    void remove(int index);

    /**
     * Sort.
     *
     * @param c the c
     */
    void sort(Comparator<? super T> c);

    /**
     * Sub list abstract list.
     *
     * @param fromIndex the from index
     * @param toIndex   the to index
     * @return the abstract list
     */
    AbstractList<T> subList(int fromIndex, int toIndex);

}
