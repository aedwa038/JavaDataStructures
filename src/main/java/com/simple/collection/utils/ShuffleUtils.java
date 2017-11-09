package com.simple.collection.utils;


import com.simple.collection.utils.SortUtils;

import java.security.SecureRandom;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by akeemedwards on 10/31/17.
 */
public class ShuffleUtils {



    public static void  shuffle(Comparable[]a) {

        shuffle(a, 0, a.length - 1);

    }

    public static void shuffle(Comparable [] a, int low, int high) {
        Random random = new Random();

        for (int i = low; i < high; i++) {
            int randomNum = random.nextInt((high - low) + 1) + low;
            SortUtils.exchange(a, i, randomNum);
        }
    }
}
