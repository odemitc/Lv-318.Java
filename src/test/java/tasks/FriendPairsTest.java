package tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class FriendPairsTest {

    @Test
    public void test() {
        assertTrue(4 == FriendPairs.countOfPairs(3));
        ;
    }
}