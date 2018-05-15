package tasks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DistanceServiceTest {
    @Test
    public void countWays() {
        int actual = 4;
        int excepted = DistanceService.countWaysToCoverDistance(3);
        assertEquals(excepted, actual);
    }

    @Test
    public void countWays2() {
        int actual = 24;
        int excepted = DistanceService.countWaysToCoverDistance(6);
        assertEquals(excepted, actual);
    }
}
