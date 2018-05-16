/*
 * Copyright (c) Team2.
 */

package tasks;

import java.util.ArrayList;

/**
 * Util class for calculating of n-th number in fibonacci sequence.
 *
 * @author Oleksii Demidov
 * @version 1.0 16 May 2018
 */

public class Fibonacci {

    /**
     * Util variable for storing processed data
     */
    private static ArrayList<Long> list = new ArrayList<Long>();

    /**
     * Static method for calculation of n-th number in fibonacci sequence.
     *
     * @param n - integer number of desired element.
     * @return The number of fibonacci that is located at the specified place of type long.
     */
    public static long fibonacciNumberCalc(int n) {

        list.clear();

        list.add(0, (long) 1);
        list.add(1, (long) 2);

        int i = 2;

        while (i < n) {
            list.add(i, list.get(i - 1) + list.get(i - 2));
            i++;
        }

        if (n == 0) {
            return list.get(0);
        } else {
            return list.get(n - 1);
        }
    }

}
