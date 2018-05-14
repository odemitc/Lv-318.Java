package tasks;

public class FenceService {

    static long countWays(int countOfPosts, int countOfColors) {
        if (countOfPosts <= 1 || countOfColors <= 0) {
            return countOfPosts * countOfColors;
        }
        long count = countOfColors;
        long waysWithSameColor = 0, waysWithDifferentColor = countOfColors;
        for (int i = 2; i <= countOfPosts; i++) {
            waysWithSameColor = waysWithDifferentColor;
            waysWithDifferentColor = count * (countOfColors - 1);
            count = (waysWithSameColor + waysWithDifferentColor);
        }
        return count;
    }
}