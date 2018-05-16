package tasks;

/**
 * Util class for calculating total number of ways to tile the given floor using 1 x m tiles.
 *
 * @author Pavlo Chornyi
 * @version 1.0 16 May 2018
 */

public class CounterService {

    /**
     * Static method for calculating total number of ways to tile the given floor using 1 x m tiles.
     *
     * @param length - integer value of length the floor
     * @param width  - integer value of with the floor
     * @return total number of ways to tile the given floor using 1 x m tiles.
     */
    public static int countWaysToTileFloor(int length, int width) {
        int count[] = new int[length + 1];
        count[0] = 0;
        int i;
        for (i = 1; i <= length; i++) {
            if (i > width) {
                count[i] = count[i - 1] + count[i - width];
            } else if (i < width) {
                count[i] = 1;
            } else {
                count[i] = 2;
            }
        }
        return count[length];
    }

}
