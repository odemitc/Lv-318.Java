package app.classes;

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

	/**
	 * this is the method responsible for counting the number of pairs possible given the assignment rules
	 * the method as explained above applies a constant manipulation in order to achieve the result
	 * at first one method was developed for odd functions and another for even. however since java
	 * floors the division of odd numbers I believe this function works properly for any input.
	 * @param n the String representation of the number of friends
	 * @return the String representation of the number of pairs
	 */

    public static String execute(String n) {
        return String.valueOf(countPairs(Integer.valueOf(n)));
    }

	private static int countPairs(int numFriends) {

	    int baseCase = 1;
		int factorialNumFriends = 1;
		int numPairs;
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


} // end FriendPairs
