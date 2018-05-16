package tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class SequenceServiceTest {

    @Test
    public void getMaxLengthOfSubsequence() {
        long actual = 3;
        int[] sequence = {3, 4, 7, 8, 9};
        long expected = SequenceService.getMaxLengthOfSubsequence(sequence);
        assertEquals(expected, actual);
    }
}