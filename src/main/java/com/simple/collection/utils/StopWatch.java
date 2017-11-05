package com.simple.collection.utils;

/**
 * Created by akeemedwards on 11/1/17.
 */
public class StopWatch {

    private final long start;

    public StopWatch() {
        start = System.currentTimeMillis();
    }


    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     *
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public void log () {
        System.out.printf("Time (%.2f seconds)\n", elapsedTime());
    }
}
