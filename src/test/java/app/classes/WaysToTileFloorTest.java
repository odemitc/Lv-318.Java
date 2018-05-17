package app.classes;

import org.junit.Test;

import static org.junit.Assert.*;

public class WaysToTileFloorTest {

    @Test
    public void testIfBranch() {
        String expected = "Wrong input, please type in the number!";
        String result = WaysToTileFloor.execute("Some input", String.valueOf(5));
        assertEquals(expected,result);
    }

    @Test
    public void testN2M3Input() {
        long result = Long.valueOf(WaysToTileFloor.execute(String.valueOf(2), String.valueOf(3)));
        assertEquals(1, result, 0);
    }

    @Test
    public void testN4M4Input() {
        long result = Long.valueOf(WaysToTileFloor.execute(String.valueOf(4), String.valueOf(4)));
        assertEquals(2, result, 0);
    }
}
