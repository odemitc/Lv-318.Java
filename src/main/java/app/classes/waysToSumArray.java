package app.classes;

import java.util.Scanner;

/**
 * this function does not work to the full intended function
 * I could not figure out how to recursively solve this problem 
 * this function instead will find if any two numbers within the array sum to the specified number.
 * I will continue to work on this and try to come up with a better solution.
 * @author Andrew - Laptop
 * @version 1
 * @since 2018-05-17
 */
public class waysToSumArray {
	
	private static Scanner s;

	/**
	 * this function is responsible for getting the array input
	 * the function asks the user for the number of elements in the array 
	 * then the user provides the elements within the array
	 * @return
	 */
	public static int[] getArray() {
		s = new Scanner(System.in);
		System.out.println("Please enter number of array elements: ");
		int arrayElem = s.nextInt();
		int array[] = new int[arrayElem];
		System.out.println("Enter elements:");
		for (int i = 0; i < arrayElem; i++) {
			array[i] = s.nextInt();
		} // end for loop
		return array;
	} // end getArray
	
	/**
	 * this function is solely responsibly for getting the number which we sum to
	 * the function asks the user for input and then returns the number which is looked
	 * for in the array as a product.
	 * @return
	 */
	public static int getNum() {
		s = new Scanner(System.in);
		System.out.println("Please enter number to sum to: ");
		int sumNum = s.nextInt();
		return sumNum;
	} // end getNum
	
	/**
	 * this function is responsible for looking through the array and finding if two elements within 
	 * the array are able to sum to the desired product. I did not know how to recursively solve this to
	 * answer the question exactly. instead this function will find if two numbers in the array add to the product
	 * @param array
	 * @param sumTo
	 * @return
	 */
	public static int calcWays(int[] array, int sumTo) {
		int arrayLength = array.length - 1;
		int count = 0;
		int index = 0;
		boolean done = false;
		while (done == false) {
			if (array[arrayLength] < sumTo) {
				for (int i = 0; i < arrayLength; i++) {
					if (array[arrayLength] + array[i] == sumTo) {
						System.out.println(array[arrayLength] + " + " + array[i] + " is equal to " + sumTo);
						count += 1;
						done = true;
					} // end if statement
				} // end for loop
			} // end if statement
			else { System.out.println("No two numbers in this group add to " + sumTo); done = true;}
			if (array[arrayLength] > sumTo) {
				for (int i = 1; i < arrayLength; i++) {
					if (array[index] + array[i] == sumTo) {
						System.out.println(array[index] + " + " + array[i] + " is equal to " + sumTo);
						count += 1;
						done = true;
					} // end if statement
					else { index += 1; }
				} // end for loop
			} // end if
			else { System.out.println("No two numbers in this group add to " + sumTo); done = true; }
			if (array[arrayLength] == sumTo) {
				System.out.println(array[arrayLength] + " is equal to " + sumTo);
				count += 1;
				done = true;
			} // end else
		} // end while loop
		return count;
	} // end calcWays

	/**
	 * this is the main function responsible for setting up the problem
	 * this function starts the process of collecting the array elements as well as
	 * the number which is looked to sum to.
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = getArray();
		int sumNum = getNum();
		int ways = calcWays(array, sumNum);
		System.out.println("There is " + ways + " way");
	} // end main
} // end waysToSumArray
