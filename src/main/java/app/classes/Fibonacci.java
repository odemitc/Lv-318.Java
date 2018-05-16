package app.classes;

/**
 * <h1>Find n-th element of Fibonacci sequence</h1>.
 *  The Fibonacci class implements method
 *  to find which is the member of position n in Fibonacci sequence
 * <p>
 * <b>Note:</b>The sequence example: 1, 2, 3, 5, 8, 13, ....
 *
 * @author  Roman Sitchuk
 * @version 1.0
 * @since   2018-05-16
 */
public class Fibonacci {

    /**
     * This method is used to provide the acces
     * to private method fibonacci.
     *
     * @param n the String representation of element position
     * @return the String representation of the element with n-th position
     */
    public static String execute(String n) {
        return String.valueOf(fibonacci(Integer.valueOf(n)));
    }

    /**
     * This method returns the n-position element of
     * the Fibonacci sequence.
     *
     * @param number the element position
     * @return the element with n-th position
     */
    private static int fibonacci(int number) {
        if (number <= 1) return number;
        int f1 = 1;
        int f2 = 1;

        for (int i = 2; i < number; i++) {
            int temp = f2;
            f2 += f1;
            f1 = temp;
        }
        return f2;
    }
}
