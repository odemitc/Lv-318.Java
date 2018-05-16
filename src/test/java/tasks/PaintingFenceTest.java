package tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaintingFenceTest {

    @Test
    public void countWays() {
        int actual = 16;
        int excepted = PaintingFence.countWays(2, 4);
        assertEquals(excepted, actual);
    }

    @Test
    public void countWays2() {
        int actual = 864;
        int excepted = PaintingFence.countWays(5, 4);
        assertEquals(excepted, actual);
    }
}