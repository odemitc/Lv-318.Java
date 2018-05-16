package tasks;

public class WaysToSumUsingElements {
    public static int countWays(int n, int... array) {
        int[] arr = array;
        int count[] = new int[n + 1];
        count[0] = 1;

        for (int i = 1; i <= n; i++)
            for (int j = 0; j < arr.length; j++)

                if (i >= arr[j])
                    count[i] += count[i - arr[j]];

        return count[n];
    }
}
