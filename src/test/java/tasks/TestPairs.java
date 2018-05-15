package tasks;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


class TestPairs {

	@Test
	void test() {	
		assertTrue(4 == FriendPairs.countOfPairs(3));;
	}

}
