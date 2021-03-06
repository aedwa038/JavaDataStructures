package com.simple.collection.queue;

import com.simple.collection.AbstractList;

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
