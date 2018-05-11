package main.java.tasks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPairs {

	@Test
	void test() {
		FriendPairs fr = new FriendPairs();
	
		assertTrue(4 == fr.countOfPairs(3));;
	}

}
