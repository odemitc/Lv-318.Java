package tasks;

/**
 * Util class for calculating the member of position n in our row.
 * Our row: 1 1 3 5 11 21 ...
 *
 * @author Vladlen Onopko
 * @version 1.0 16 May 2018
 */

public class IntrestingRow {

    /**
     * Static method for calculating the member of position n in our row.
     *
     * @param n - The number that represents position in our row.
     * @return The value of member in our row.
     */
    public static int intrestingRow(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return intrestingRow(n - 1) + 2 * intrestingRow(n - 2);
    }
}
