package app.classes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LongSubWithDifOneTest {
    @Parameterized.Parameter(0)
    public String m1;

    @Parameterized.Parameter(1)
    public String result;


    // creates the test data
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { {"","wrong iput value" }, { " ","wrong iput value"}, {"1 2 3 4 5 6 3 4 2 8","6"},{"-6 -5 -4 -3 -2 -1 6 3 8","6"}};
        return Arrays.asList(data);

    }


    @Test
    public void testInput() {
        assertEquals("True", result, LongSubWithDifOne.execute(m1));
    }
}
