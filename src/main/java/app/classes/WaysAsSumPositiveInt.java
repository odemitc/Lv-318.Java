package app.classes;

/**
 * <h1>Ways to write n as sum of two or more positive integers</h1>.
 * The Fibonacci class implements method
 * to find ways to write n as sum of two or more positive integers
 *
 * @author Roman Sitchuk
 * @version 1.0
 * @since 2018-05-16
 */
public class WaysAsSumPositiveInt {

    /**
     * This method is used to provide the acces
     * to private method calculateWays.
     *
     * @param n the String representation of the element
     * @return the String representation of the result, which is number of ways
     */
    public static String execute(String n) {
        if (!n.matches("\\d+")) {
            return "Wrong input, please type in the number!";
        }
        return String.valueOf(calculateWays(Integer.valueOf(n)));
    }

    private static int calculateWays(int n) {
        //store the number of ways for i
        int[] waysCount = new int[n + 1];

        //basic case
        waysCount[0] = 1;

        for (int i = 1; i <= n; i++) {
            waysCount[i] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i; j <= n; j++) {
                waysCount[j] += waysCount[j - i];
            }
        }
        return waysCount[n];
    }


}
