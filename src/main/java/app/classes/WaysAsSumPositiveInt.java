package app.classes;

public class WaysAsSumPositiveInt {

    public static String execute (String n)
    {
        return String.valueOf(calculateWays(Integer.valueOf(n)));
    }

    private static int calculateWays(int n)
    {
        //store the number of ways for i
        int [] waysCount = new int[n + 1];

        //basic case
        waysCount[0] = 1;

        for (int i = 1; i <= n; i++ ){
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
