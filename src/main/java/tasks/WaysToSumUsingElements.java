package tasks;

/**
 * Util class for finding how many ways we have to
 * represent one number with a given array of numbers.
 *
 * @author Vladlen Onopko
 * @version 1.0 16 May 2018
 */
public class WaysToSumUsingElements {

    /**
     * Static method finding how many ways we have to
     * represent number n with a given array of numbers.
     *
     * @param n     - The number which has to be represented.
     * @param array - Array of numbers through which our number
     *              has to be represented.
     * @return The number of ways to represent our number n.
     */
    public static int countWays(int n, int[] array) {
        int[] count = new int[n + 1];
        count[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i >= array[j]) {
                    count[i] += count[i - array[j]];
                }
            }
        }

        return count[n];
    }
}
