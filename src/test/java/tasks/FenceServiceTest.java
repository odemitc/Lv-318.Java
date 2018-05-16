package tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class FenceServiceTest {

    @Test
    public void countWays() {
        long actual = 16;
        long excepted = FenceService.countWays(2, 4);
        assertEquals(excepted, actual);
    }

    @Test
    public void countWays2() {
        long actual = 42150;
        long excepted = FenceService.countWays(6, 6);
        assertEquals(excepted, actual);
    }
}