package app.classes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ModufFibonacciTest {
    @Parameterized.Parameter(0)
    public String m1;

    @Parameterized.Parameter(1)
    public String result;


    // creates the test data
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { {"6","4" }, { "8","9"}, {"0","wrong input value"},{"-2","wrong input value"},{"1","1"}};
        return Arrays.asList(data);

    }


    @Test
    public void testInput() {

        assertEquals("True", result, ModificationFibonachi.execute(m1));
    }
}
