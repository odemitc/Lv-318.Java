package app.classes;

/**
 * <h1>Ways to tile the floor</h1>.
 * The WaysToTileFloor class implements method
 * to find ways to count the number of ways to tile the given n x m floor using 1 x m tiles
 *
 * @author Roman Sitchuk
 * @version 1.0
 * @since 2018-05-16
 */
public class WaysToTileFloor {

    /**
     * This method is used to provide the acces
     * to private method.
     *
     * @param n the String representation of the n parameter
     * @param m the String representation of the m parameter
     * @return the String representation of the result, which is number of ways
     */
    public static String execute(String n, String m) {
        if (!n.matches("\\d+") || !m.matches("\\d+")) {
            return "Wrong input, please type in the number!";
        }
        return String.valueOf(countTheWays(Integer.valueOf(n), Integer.valueOf(m)));
    }

    private static int countTheWays(int n, int m) {

        //for storing values of subproblems
        int[] ways = new int[n + 1];
        ways[0] = 0;
        for (int i = 1; i <= n; i++) {

            //case when n < m
            if (i < m) {
                ways[i] = 1;
            }

            //if n > m
            else if (i > m) {
                ways[i] = ways[i - 1] + ways[i - m];
            }

            //if n == m
            else {
                ways[i] = 2;
            }
        }
        return ways[n];
    }
}
