package app.classes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OptimizedFenceTest {
    @Test
    public void testExampleInputCase() {
        assertTrue(16 == Integer.valueOf(OptimizedFence.execute(String.valueOf(2), String.valueOf(4))));
    }

}
