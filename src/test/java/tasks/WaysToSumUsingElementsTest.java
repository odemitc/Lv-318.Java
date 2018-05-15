package tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class WaysToSumUsingElementsTest {
    @Test
    public void test() {
        int n = 7;
        int arr[] = {1, 5, 6};
        assertTrue(6 == WaysToSumUsingElements.countWays(n, arr));
    }
}
