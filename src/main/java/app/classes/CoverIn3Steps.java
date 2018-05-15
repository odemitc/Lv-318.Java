package app.classes;

public class CoverIn3Steps {

    public static String execute(String n){
        return String.valueOf(calcDistance(Integer.valueOf(n)));
    }

    private static int calcDistance(int distance) {
        int[] count = new int[distance + 1];

        count[0] = 1;
        count[1] = 1;
        count[2] = 2;

        for (int i = 3; i <= distance; i++) {
            count[i] = count[i - 1] + count[i - 2] + count[i - 3];
        }

        return count[distance];
    }
}
