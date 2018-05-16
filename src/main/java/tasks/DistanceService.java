package tasks;

public class DistanceService {
    //s(0)=1
    //s(n)=s(n-1)+s(n-1)+s(n-2)
    public static int countWaysToCoverDistance(int distance) {
        int[] countArray = new int[distance + 1];
        countArray[0] = 1;
        countArray[1] = 2;
        countArray[2] = 4;
        for (int i = 3; i <= distance; i++) {
            countArray[i] = countArray[i - 1] + countArray[i - 2] + countArray[i - 3];
        }
        return countArray[distance - 1];
    }
}