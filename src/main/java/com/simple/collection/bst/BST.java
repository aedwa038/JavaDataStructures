package com.simple.collection.bst;

/**
 * Created by akeemedwards on 11/10/17.
 */
public interface BST <Key extends Comparable<Key>, Value> {
    boolean isEmpty();
    boolean contains(Key key);
    int size();
    Value get(Key key);
    void put(Key key, Value val);
    void deleteMin();
    void deleteMax();
    Key min();
    Key max();
    int rank(Key key);
    Iterable<Key> keys();
    Iterable<Key> keys(Key lo, Key hi);
    int size(Key lo, Key hi);
    Key floor(Key key);
    Key ceiling(Key key);
    void delete(Key key);


}
