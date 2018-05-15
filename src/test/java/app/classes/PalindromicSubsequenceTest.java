package app.classes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromicSubsequenceTest {
    @Test
    public void testExampleCase() {
        int result = Integer.valueOf(PalindromicSubsequence.execute("banana"));
        assertEquals(5, result, 0);
    }

    @Test
    public void testExampleCase2() {
        int result = Integer.valueOf(PalindromicSubsequence.execute("mom"));
        assertEquals(3, result, 0);
    }

    @Test
    public void testBigSequence() {
        int result = Integer.valueOf(PalindromicSubsequence.execute("Process finished mom banana tattarrattat"));
        assertEquals(12, result, 0);
    }
}
