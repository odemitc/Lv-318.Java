package app.classes;

public class Fence {

    public static String execute(String n){
        return "";
    }

    private static int numWays(int n, int k) {
        if (n <= 0 || k <= 0) {
            return 0;
        }

        if (n == 1) {
            return k;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = k;
        dp[2] = k + k * (k - 1);
        for (int i = 3; i <= n; i++) {
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n];
    }
}
