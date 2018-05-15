package tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromServiceTest {

    @Test
    public void test() {
        String banana = "banana";

        assertTrue(5 == PalindromService.getMaxLengthOfPalindrom(banana));
    }
}