/*
 * Copyright (c) Team2.
 */
package tasks;

/**
 * Util class to count number of ways to connect n (where n is even) points on a
 * circle such that no two connecting lines cross each other and every
 * point is connected with one other point.
 *
 * @author Oleksii Demidov
 * @version 1.0 17 May 2018
 */
public class PathsWithoutCrossing {

    /**
     * Static method to count number of ways to connect n points on a circle
     * such that no two connecting lines cross each other and every point
     * is connected with one other point.
     *
     * @param n - integer number of points on a circle.
     * @return Amount of paths witout crosses of type int.
     */
    public static int amountOfPathsWithoutCrosses(int n) {

        if (n % 2 == 0) {
            return catalanNumber(n / 2);
        } else {
            return 0;
        }

    }

    /**
     *Private util method for calculation specified catalan number.
     * @param n - integer number of item of interest.
     * @return Catalan number on n-th place of type int.
     */
    private static int catalanNumber(int n) {

        int res = 0;

        if (n <= 1) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            res += catalanNumber(i) * catalanNumber(n - i - 1);
        }
        return res;
    }
}
