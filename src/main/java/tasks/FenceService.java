
package tasks;

/**
 * Util class for calculating total number of ways of painting the
 * fence such that at most 2 adjacent posts have the same color.
 *
 * @author Pavlo Chornyi
 * @version 1.0 16 May 2018
 */

public class FenceService {

    /**
     * Static method for calculating total number of ways to of painting the
     * fence
     *
     * @param countOfPosts  - integer value of  count a posts
     * @param countOfColors - integer value of  count a different colors
     * @return number of ways of painting the
     * fence such that at most 2 adjacent posts have the same color.
     */
    public static long countWays(int countOfPosts, int countOfColors) {
        if (countOfPosts <= 1 || countOfColors <= 0) {
            return countOfPosts * countOfColors;
        }
        long count = countOfColors;
        long waysWithSameColor = 0, waysWithDifferentColor = countOfColors;
        for (int i = 2; i <= countOfPosts; i++) {
            waysWithSameColor = waysWithDifferentColor;
            waysWithDifferentColor = count * (countOfColors - 1);
            count = (waysWithSameColor + waysWithDifferentColor);
        }
        return count;
    }

}

