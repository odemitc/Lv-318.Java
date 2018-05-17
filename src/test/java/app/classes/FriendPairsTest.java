package app.classes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FriendPairsTest {
    @Test
    public void testFirstNumber() {
        int expected = 4;
        int result = Integer.valueOf(FriendPairs.execute(String.valueOf(3)));
        assertEquals(expected, result, 0);
    }

}
