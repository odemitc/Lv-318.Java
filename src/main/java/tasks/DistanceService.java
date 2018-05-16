package tasks;

/**
 * Util class for calculating total number of ways to cover distance in 3 steps
 *
 * @author Pavlo Chornyi
 * @version 1.0 16 May 2018
 */
public class DistanceService {


    /**
     * Static method for calculating total number of ways to cover distance in 3 steps
     * s(0)=1
     * s(n)=s(n-1)+s(n-1)+s(n-2)
     *
     * @param distance - integer value of distance
     * @return the count of ways to cover this distance in 3 steps
     */
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