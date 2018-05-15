package main.java.tasks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPathsWithoutCrossing {

	@Test
	void test() {
		PathsWithoutCrossing tmp = new PathsWithoutCrossing();
		
		assertTrue((1 == PathsWithoutCrossing.amountOfPathsWithoutCrosses(2)) 
				& (2 == PathsWithoutCrossing.amountOfPathsWithoutCrosses(4)) 
				& (0 == PathsWithoutCrossing.amountOfPathsWithoutCrosses(3)));
	}

}
