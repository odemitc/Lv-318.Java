/*
 * @(#)LowHightEfforts.java 1.00 2018/16/05
 *
 * Copyright (c) 2018 Team2.
 *
 */
package tasks;

/**
 * This class  write to find the maximum amount of cost can be performed within n days.
 *
 * @author Mariia Oleksiuk
 * @version 1.0 16 May 2018
 */
public class LowHightEfforts {

    /**
     * Static method which calculate maximum amount of cost can be performed for these days.
     * Notice: high level task can be chosen only if no task on the previous day.
     *
     * @param days       - integer number of days for which we can perform tasks.
     * @param lowTasks   - array of low effort tasks which can be performed for these days.
     * @param hightTasks - array of high effort tasks which can be performed for these days.
     * @return The member of maximum amount of cost can be performed for these days.
     */
    public static int maxAmountTasks(int days, int lowTasks[], int hightTasks[]) {
        int maxAmount = 0;
        if (days == 0) {
            return 0;
        }
        for (int i = 1; i <= days; i++) {
            if (((i - 1) == 0) || (hightTasks[i - 1] == 0)) {
                maxAmount = maxAmount + hightTasks[i - 1];
            } else {
                maxAmount = maxAmount + lowTasks[i - 1];
            }
        }
        return maxAmount;
    }
}
