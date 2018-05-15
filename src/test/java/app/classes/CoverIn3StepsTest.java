package app.classes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoverIn3StepsTest {
    @Test
    public void testInputValue3() {
        long result = Long.valueOf(CoverIn3Steps.execute(String.valueOf(3)));
        assertEquals(4, result, 0);
    }

    @Test
    public void testInputValue6() {
        long result = Long.valueOf(CoverIn3Steps.execute(String.valueOf(6)));
        assertEquals(24, result, 0);
    }


}
