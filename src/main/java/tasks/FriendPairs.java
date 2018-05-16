/*
 * Copyright (c) Team2.
 */
package tasks;

/**
 * Util class for calculating total number of ways in which
 * specified amount of friends can remain single or can be paired up.
 *
 * @author Oleksii Demidov
 * @version 1.0 16 May 2018
 */

public class FriendPairs {

    /**
     * Static method for calculation number of ways in which friends
     * can remain single or can be paired up.
     *
     * @param n - integer number of friends.
     * @return Count ways of type long.
     */
    public static long countOfPairs(int n) {
        return combinations(n, 2) + 1;
    }

    /**
     * Private util method for calculation of factorial (n!).
     *
     * @param n - integer.
     * @return Specified factorial of type long.
     */
    private static long factorial(int n) {

        long valueToReturn = 1;

        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                valueToReturn = valueToReturn * i;
            }
        }

        return valueToReturn;

    }

    /**
     * Private util method for calculation amount of ways
     * how to chose k items from given n.
     *
     * @param n - int amount of all elements.
     * @param k - integer number to chose how much from given n.
     * @return Amount of ways how to chose k items from given n of type long.
     */
    private static long combinations(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

}
