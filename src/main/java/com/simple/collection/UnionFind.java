package com.simple.collection;

/**
 * Created by akeem on 10/15/17.
 */
public interface UnionFind {

    /**
     * Returns the number of components.
     *
     * @return the number of components (between {@code 1} and {@code n})
     */
    int count();

    /**
     * Returns true if the the two sites are in the same component.
     *
     * @return {@code true} if the two sites {@code p} and {@code q} are in the same component;
     *         {@code false} otherwise
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    boolean connected();

    /**
     * Merges the component containing site {@code p} with the
     * the component containing site {@code q}.
     *
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    void union();

    /**
     * Returns the component identifier for the component containing site {@code p}.
     *
     * @return the component identifier for the component containing site {@code p}
     * @throws IllegalArgumentException unless {@code 0 <= p < n}
     */
    int find();

}
