package tasks;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

class TestPathsWithoutCrossing {

	@Test
	void test() {
		PathsWithoutCrossing tmp = new PathsWithoutCrossing();
		
		assertTrue((1 == PathsWithoutCrossing.amountOfPathsWithoutCrosses(2)) 
				& (2 == PathsWithoutCrossing.amountOfPathsWithoutCrosses(4)) 
				& (0 == PathsWithoutCrossing.amountOfPathsWithoutCrosses(3)));
	}

}
