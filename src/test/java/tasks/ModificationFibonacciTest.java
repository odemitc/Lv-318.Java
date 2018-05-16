package tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class ModificationFibonacciTest {

    @Test
    public void findPossition() {
        long actual = 1;
        long expected = ModificationFibonacci.findPossition(3);
        assertEquals(expected, actual);
    }

    @Test
    public void findPossition1() {
        long actual = 4;
        long expected = ModificationFibonacci.findPossition(6);
        assertEquals(expected, actual);
    }
}