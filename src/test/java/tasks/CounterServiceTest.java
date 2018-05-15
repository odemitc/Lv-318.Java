package tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class CounterServiceTest {

    @Test
    public void countWaysToTileFloor() {
        int actual = 1;
        int excepted = CounterService.countWaysToTileFloor(2,3);
        assertEquals(excepted, actual);
    }
    @Test
    public void countWaysToTileFloor2() {
        int actual = 13;
        int excepted = CounterService.countWaysToTileFloor(8,3);
        assertEquals(excepted, actual);
    }
}