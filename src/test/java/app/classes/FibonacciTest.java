package app.classes;

import org.junit.Test;

import static org.junit.Assert.*;



public class FibonacciTest {

    @Test
    public void testIfBranch() {
        String expected = "Wrong input, please type in the number!";
        String result = Fibonacci.execute("Some input");
        assertEquals(expected,result);
    }

    @Test
    public void testFirstNumber() {
        long result = Long.valueOf(Fibonacci.execute(String.valueOf(1)));
        assertEquals(1, result, 0);
    }

    @Test
    public void testThirdNumber() {
        long result = Long.valueOf(Fibonacci.execute(String.valueOf(3)));
        assertEquals(2, result, 0);
    }

    @Test
    public void testFifthNumber() {
        long result = Long.valueOf(Fibonacci.execute(String.valueOf(5)));
        assertEquals(5, result, 0);
    }

}