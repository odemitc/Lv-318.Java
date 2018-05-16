package tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    @Test
    public void fibonacciNumberCalc() {
       long actual = 3;
       long expected = Fibonacci.fibonacciNumberCalc(3);
       assertEquals(expected, actual);

    }

    @Test
    public void fibonacciNumberCalc1() {
        long actual = 8;
        long expected = Fibonacci.fibonacciNumberCalc(5);
        assertEquals(expected, actual);

    }
}