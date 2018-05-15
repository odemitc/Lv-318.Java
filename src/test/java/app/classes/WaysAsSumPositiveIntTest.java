package app.classes;

import org.junit.Test;

import static org.junit.Assert.*;

public class WaysAsSumPositiveIntTest {

    @Test
    public void testNumber5() {
        long result = Long.valueOf(WaysAsSumPositiveInt.execute(String.valueOf(5)));
        assertEquals(6, result, 0);
    }

    @Test
    public void testNumber9() {
        long result = Long.valueOf(WaysAsSumPositiveInt.execute(String.valueOf(9)));
        assertEquals(29, result, 0);
    }
}
