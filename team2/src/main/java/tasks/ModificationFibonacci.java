package tasks;

import java.util.ArrayList;
import java.util.List;


public class ModificationFibonacci {

	private List<Integer> fibonachiList = new ArrayList<>();

	private void createFibonacciList(int n) {
		fibonachiList.clear();
		fibonachiList.add(0, 1);
		fibonachiList.add(1, 1);
		fibonachiList.add(2, 1);
		fibonachiList.add(3, 2);
		for (int i = 4; i < n; i++) {
			int element = fibonachiList.get(i - 1) + fibonachiList.get(i - 3);
			fibonachiList.add(i, element);

		}

	}

	public int findPossition(int k) {
		createFibonacciList(k);
		return fibonachiList.get(k - 1);
	}
}
