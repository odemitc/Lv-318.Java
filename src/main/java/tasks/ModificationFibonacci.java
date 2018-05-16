/*
 * @(#)ModificationFibonacci.java 1.00 2018/16/05
 *
 * Copyright (c) 2018 Team2.
 *
 */

package tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * This class create a Modified Fibonacci sequence and find the element of specific position.
 *
 * @author Mariia Oleksiuk
 * @version 1.0 16 May 2018
 */
public class ModificationFibonacci {

    /**
     * Variable for storing data
     */
    private static List<Integer> fibonachiList = new ArrayList<>();

    /**
     * Static method which create a sequence of Modified Fibonacci.
     *
     * @param n - integer number to which position of Fibonacci sequence need to be created.
     */
    private static void createFibonacciList(int n) {
        fibonachiList.clear();
        fibonachiList.add(0, 1);
        fibonachiList.add(1, 1);
        fibonachiList.add(2, 1);
        fibonachiList.add(3, 2);
        for (int i = 4; i < n; i++) {
            int element = fibonachiList.get(i - 1) + fibonachiList.get(i - 3);
            fibonachiList.add(i, element);

        }

    }

    /**
     * Static method which find the element of  specific position in sequence of Modified Fibonacci.
     *
     * @param k - integer number of position of element we need to find.
     * @return The member of position k in Modification Fibonacci sequence.
     */
    public static int findPossition(int k) {
        createFibonacciList(k);
        return fibonachiList.get(k - 1);
    }
}
