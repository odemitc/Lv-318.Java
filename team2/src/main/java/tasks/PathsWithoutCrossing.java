package tasks;

public class PathsWithoutCrossing {

	public long amountOfPathsWithoutCrosses(int n) {

		if (n % 2 == 0) {
			return catalanNumber(n / 2);
		} else {
			return 0;
		}

	}

	private int catalanNumber(int n) {

		int res = 0;

		if (n <= 1) {
			return 1;
		}

		for (int i = 0; i < n; i++) {
			res += catalanNumber(i) * catalanNumber(n - i - 1);
		}
		return res;
	}
}
