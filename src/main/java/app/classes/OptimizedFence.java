package app.classes;

/**
 * <h1>Optimized painting fence: use one variable instead of a table</h1>
 *  The OptimizedFence class implements method
 *  to find out the number of ways of painting the fence such that
 *  at most 2 adjacent posts have the same color.
 * @author  Stanislav Turchynskyi
 * @version 1.0
 * @since   2018-05-16
 */

public class OptimizedFence {

    /**
     * This method is used to provide the access
     * to private method {@link #numWays(int, int)}.
     *
     * @param n the String representation of first parameter
     * @param m the String representation of first parameter
     * @return the String representation of number of ways to paint the fence
     */
    public static String execute(String n, String m) {
        return String.valueOf(numWays(Integer.valueOf(n), Integer.valueOf(m)));
    }

    /**
     * This method calculate number of ways of painting the fence such that
     *  at most 2 adjacent posts have the same color.
     * @param posts number of posts
     * @param colors number of colors
     * @return number of ways to paint the fence
     */
    private static int numWays(int posts, int colors) {
        if (posts <= 0 || colors <= 0) {
            return 0;
        }
        if (posts == 1) {
            return colors;
        }

        int preSame = 0;
        int preDiff = colors;
        int sum;

        for (int i = 1; i < posts; i++) {
            int same = preDiff;
            int diff = (colors - 1) * (preSame + preDiff);

            preSame = same;
            preDiff = diff;
        }
        sum = preSame + preDiff;

        return sum;
    }
}
