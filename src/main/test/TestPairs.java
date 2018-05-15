package main.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPairs {

	@Test
	void test() {	
		assertTrue(4 == FriendPairs.countOfPairs(3));;
	}

}
