package tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class LowHightEffortsTest {

    @Test
    public void test() {
        int n = 5;
        int lowTasks [] = {1, 5, 4, 5, 3};
        int hightTasks [] = {3, 6, 8, 7, 6};

        assertTrue(20 == LowHightEfforts.maxAmountTasks(n, lowTasks, hightTasks));;
    }
}