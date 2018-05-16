package tasks;

import java.util.Arrays;


/**
 * Util class for finding how many ways are possible
 * to calculate one number with positive integers.
 *
 * @author Vladlen Onopko
 * @version 1.0 16 May 2018
 */
public class WaysToSumUsingPositiveIntegers {

    /**
     * Static method finding how many ways are possible to calculate one number
     * with positive integers.
     *
     * @param n - The positive integer we have to to calculate in
     *          how many different ways is possible to be represented
     *          with positive integers.
     * @return The number of ways which are possible to calculate one
     * number with positive integers.
     */
    public static int countWays(int n) {
        int[] table = new int[n + 1];
        Arrays.fill(table, 0);
        table[0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = i; j <= n; j++) {
                table[j] += table[j - i];
            }
        }

        return table[n];
    }
}
