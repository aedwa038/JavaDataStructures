package com.simple.collection;

import com.simple.collection.AbstractList;
import com.simple.collection.ListADT;

import java.util.Comparator;

/**
 * Created by akeem on 10/5/17.
 *
 * @param <T> the type parameter
 */
public interface Queue <T> extends AbstractList<T> {

     /**
      * Poll t.
      *
      * @return the t
      */
     T poll();

     /**
      * Offer.
      *
      * @param t the t
      */
     void offer(T t);



}
