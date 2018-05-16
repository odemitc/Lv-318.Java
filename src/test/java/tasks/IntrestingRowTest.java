package tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntrestingRowTest {

    @Test
    public void intrestingRow() {
        long actual = 1;
        long expected = IntrestingRow.intrestingRow(1);
        assertEquals(expected, actual);
    }

    @Test
    public void intrestingRow1() {
        long actual = 11;
        long expected = IntrestingRow.intrestingRow(5);
        assertEquals(expected, actual);
    }
}