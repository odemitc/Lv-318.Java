package tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathsWithoutCrossingTest {

    @Test
    public void test() {
        PathsWithoutCrossing tmp = new PathsWithoutCrossing();

        assertTrue((1 == PathsWithoutCrossing.amountOfPathsWithoutCrosses(2))
                & (2 == PathsWithoutCrossing.amountOfPathsWithoutCrosses(4))
                & (0 == PathsWithoutCrossing.amountOfPathsWithoutCrosses(3)));
    }
}