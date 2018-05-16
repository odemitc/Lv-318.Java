package tasks;

import java.util.Arrays;

public class WaysToSumUsingPositiveIntegers {
    public static int countWays(int n) {
        int table[] = new int[n + 1];
        Arrays.fill(table, 0);
        table[0] = 1;

        for (int i = 1; i < n; i++)
            for (int j = i; j <= n; j++)
                table[j] += table[j - i];

        return table[n];
    }
}
