package main.java.tasks;

import java.util.ArrayList;

public class Fibonacci {

		private static ArrayList<Long> list = new ArrayList<Long>();

		public static long fibonacciNumberCalc(int n) {

			list.clear();

			list.add(0, (long) 1);
			list.add(1, (long) 2);

			int i = 2;

			while (i < n) {
				list.add(i, list.get(i - 1) + list.get(i - 2));
				i++;
			}

			if (n == 0){
				return list.get(0);
			}else{
				return list.get(n-1);
			}
		}
	
}
