package app.classes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class HighLowEffortsTest {
    @Parameterized.Parameter(0)
    public String m1;
    @Parameterized.Parameter(1)
    public String m2;
    @Parameterized.Parameter(2)
    public String result;


    // creates the test data
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { "2 3 4 5 4" ,"7 6 5 4 8", "23" },
                                            {"4 3 6 1 5", "6 4 8 5 9", "24" },
                                             {"5 3 6", "7 4 9 12 11", "27" }};
        return Arrays.asList(data);

    }


    @Test
    public void testInput() {

        assertEquals("True", result, HighLowEfforts.execute(m1,m2));
    }


}
