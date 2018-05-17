package app.classes;
/**
 * <h1>Work to be with High-effort or with Low-effort</h1>
 *  The goal: We have n days and for each day (d) you could either perform
 *  a high effort tasks (hi) or a low effort tasks (li) or no task with the
 *  constraint (it is written 0) that you can choose a high-effort tasks
 *  only if you chose no task on the previous day. Write a program
 *  to find the maximum amount of cost you can perform within these n days.
 * @author  Iryna Holod
 * @version 1.0
 * @since   2018-05-17
 */
public class HighLowEfforts {
    /**
     * This method is used to provide the access
     * to private method {@link #maxAmountTasks(String, String)}.
     *
     * @param strLowTasks the String representation of the cost of low effort work
     * @param strHighTasks the String representation of the cost of high effort work
     * @return the String representation of the maximum amount of cost you can perform
     */
    public static String execute(String strLowTasks, String strHighTasks) {
        return maxAmountTasks(strLowTasks, strHighTasks);
    }

    /**
     * This method calculate the maximum amount of cost you can perform within these n days.
     * @param strLowTasks the cost of low effort work
     * @param strHighTasks the cost of high effort work
     * @return the maximum amount of cost you can perform
     */

    private static String maxAmountTasks(String strLowTasks, String strHighTasks) {


        String temp1[] = strHighTasks.split(" ");
        String temp2[] = strLowTasks.split(" ");
        int days = Math.max(temp1.length, temp2.length);


        int highTasks[] = new int[days];
        for (int i = 0; i < days; i++) {
            if (i == temp1.length) {
                highTasks[i] = 0;
            } else {
                highTasks[i] = Integer.parseInt(temp1[i]);
            }


        }


        int lowTasks[] = new int[days];
        for (int i = 0; i < days; i++) {
            if (i == temp2.length) {
                lowTasks[i] = 0;
            } else {
                lowTasks[i] = Integer.parseInt(temp2[i]);
            }

        }

        int maxAmount = highTasks[0];

        if (days == 0) {
            return "wrong input value";
        }
        for (int i = 2; i < highTasks.length; i += 2) {
            for (int j = i; j < lowTasks.length; j += 2) {
                if (lowTasks[j - 1] + lowTasks[j] > highTasks[i]) {
                    maxAmount += (lowTasks[j - 1] + lowTasks[j]);
                    break;
                } else {
                    maxAmount += highTasks[i];
                    break;
                }
            }
        }
        return Integer.toString(maxAmount);
    }
}
