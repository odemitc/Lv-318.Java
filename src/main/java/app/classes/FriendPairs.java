package app.classes;

import java.util.Scanner;

/**
 * This method is responsible for finding the number of pairs between friends.
 * the pairings are limited to singles or doubles. The answer to this problem
 * can be found by using constant manipulation on the input number of friends.
 * the result will always be the base case of 1 + the combination factorial / ordering + the combination divided in half
 * @author Andrew - Laptop
 * @version 1
 * @since 2018-05-17
 */
public class FriendPairs {
	
	static Scanner answer;
	
	/** 
	 * this is the method responsible for counting the number of pairs possible given the assignment rules
	 * the method as explained above applies a constant manipulation in order to achieve the result
	 * at first one method was developed for odd functions and another for even. however since java
	 * floors the division of odd numbers I believe this function works properly for any input.
	 * @return
	 */
	public static int countPairs() {
		System.out.print("Please enter the number of friends: ");
		answer = new Scanner(System.in);
		String start = answer.nextLine();
		int numFriends = Integer.parseInt(start);
		int baseCase = 1;
		int factorialNumFriends = 1;
		int numPairs = 0;
		if (numFriends > 1) {
				for (int i = 1; i <= numFriends; i++) {
					factorialNumFriends = factorialNumFriends * i;
				} // end for loop
				factorialNumFriends = factorialNumFriends / numFriends;
				numPairs = baseCase + factorialNumFriends + (factorialNumFriends / 2);
		} // end if statement
		else if (numFriends == 0) {
			numPairs = 0;
		} // end if statement
		else { numPairs = 1; }
		return numPairs;
	} // end countPairs
	
	/**
	 * main class method responsible for calling countPairs method and displaying result
	 * @param args
	 */
	public static void main(String[] args) {
		int numPairs = countPairs();
		System.out.println("The number of pairings is: " + numPairs);
	} // end main	
} // end FriendPairs
