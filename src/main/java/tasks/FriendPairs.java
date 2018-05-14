package main.java.tasks;

public class FriendPairs {

	public static long countOfPairs(int n) {
		return combinations(n, 2)+1;
	}

	private static long factorial(int n) {

		long valueToReturn = 1;

		if (n > 0) {
			for (int i = 1; i <= n; i++) {
				valueToReturn = valueToReturn * i;
			}
		}

		return valueToReturn;

	}

	private static long combinations(int n, int k) {
		return factorial(n) / (factorial(k) * factorial(n - k));
	}

}
