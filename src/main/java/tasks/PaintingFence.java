/*
 * @(#)PaintingFence.java 1.00 2018/16/05
 *
 * Copyright (c) 2018 Team2.
 *
 */
package tasks;

/**
 * This class for finding out the number of ways of painting the fence such that at most 2 adjacent posts have the same color.
 *
 * @author Mariia Oleksiuk
 * @version 1.0 16 May 2018
 */
public class PaintingFence {

    /**
     * Static method which count ways of painting the fence such that at most  2 adjacent posts have the same color.
     *
     * @param n - integer number of fence`s posts.
     * @param k - integer number of colors.
     * @return - ways of painting the fence with n number of posts and k number of colors.
     */
    public static int countWays(int n, int k) {
        int same = 0;
        int different = k;
        for (int i = 2; i <= n; i++) {
            int tmp = different;
            different = (same + different) * (k - 1);
            same = tmp;
        }
        return same + different;
    }

}

