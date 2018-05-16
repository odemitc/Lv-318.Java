package app.classes;

/**
 * <h1>Ways to cover in 3 steps</h1>
 *  The CoverIn3Steps class implements method
 *  to count total number of ways to cover the distance with 1, 2 and 3 steps.
 * @author  Stanislav Turchynskyi
 * @version 1.0
 * @since   2018-05-16
 */

public class CoverIn3Steps {

    /**
     * This method is used to provide the access
     * to private method {@link #calcDistance(int)}.
     *
     * @param n the String representation of first parameter
     * @return the String representation of number of ways to cover the distance
     */
    public static String execute(String n) {
        return String.valueOf(calcDistance(Integer.valueOf(n)));
    }

    /**
     * This method calculate total number of ways
     * to cover the distance with 1, 2 and 3 steps.
     *
     * @param distance distance
     * @return number of ways to cover the distance
     */
    private static int calcDistance(int distance) {
        int[] count = new int[distance + 1];

        count[0] = 1;
        count[1] = 1;
        count[2] = 2;

        for (int i = 3; i <= distance; i++) {
            count[i] = count[i - 1] + count[i - 2] + count[i - 3];
        }

        return count[distance];
    }
}
