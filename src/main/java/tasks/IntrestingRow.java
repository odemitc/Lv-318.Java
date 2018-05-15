package tasks;

public class IntrestingRow {
    public static int intrestingRow(int n)
    {
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        return intrestingRow(n - 1) + 2 * intrestingRow(n - 2);
    }
}
