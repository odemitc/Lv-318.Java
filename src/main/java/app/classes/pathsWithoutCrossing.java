package app.classes;

import java.util.Scanner;

/**
 * this question asks for how many pairs are possible in an even distribution of points around a circle
 * the problem is that the way these points are distributed around the circle is not exactly specified
 * therefore i assumed that the points go around the circle in a linear manner.
 * this means that the simplest solution to this problem will always be half the number of points if even.
 * @author Andrew - Laptop
 *
 */
public class pathsWithoutCrossing {
	
	private static Scanner s;

	/** 
	 * if an odd number is entered the function defaults to 0 as requested
	 * due to my interpretation of this question the optimal answer will always
	 * be half the number of the points in the circle. 
	 * @return
	 */
	public static int numOfPaths() {
		s = new Scanner(System.in);
		System.out.println("Please enter the number of points on the circle: ");
		int numPoints = s.nextInt();
		if (numPoints % 2 == 1) {
			return 0;
		} // end if statement
		else {
			return numPoints / 2;
		} // end else
	} // end numOfPaths
	
	public static void main(String[] arg) {
		int num = numOfPaths();
		System.out.println("The number of pairs possible is " + num);
	} // end main
} // end pathsWithoutCrossing
