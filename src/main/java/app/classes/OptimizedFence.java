package app.classes;

public class OptimizedFence {

    public static String execute(String n, String m) {
        return String.valueOf(numWays(Integer.valueOf(n), Integer.valueOf(m)));
    }

    private static int numWays(int n, int k) {

        if (n <= 0 || k <= 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }

        int preSame = 0;
        int preDiff = k;
        int sum;

        for (int i = 1; i < n; i++) {
            int same = preDiff;
            int diff = (k - 1) * (preSame + preDiff);

            preSame = same;
            preDiff = diff;
        }
        sum = preSame + preDiff;

        return sum;
    }
}
