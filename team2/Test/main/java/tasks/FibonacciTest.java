package main.java.tasks;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void test() {

		Fibonacci fibonacci = new Fibonacci();

		assertTrue((3 == fibonacci.fibonacciNumberCalc(3)) || (8 == fibonacci.fibonacciNumberCalc(5)) || (20 != fibonacci.fibonacciNumberCalc(7)));
	}

}
