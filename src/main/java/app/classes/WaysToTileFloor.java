package app.classes;

public class WaysToTileFloor {

    public static String execute (String n, String m){
        return String.valueOf(countTheWays(Integer.valueOf(n), Integer.valueOf(m)));
    }

    private int countTheWays(int n, int m)
    {
        //for storing values of subproblems
        int [] ways = new int[n+1];
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
