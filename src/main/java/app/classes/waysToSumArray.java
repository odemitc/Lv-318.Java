package app.classes;

import java.util.Scanner;

/**
 * this function does not work to the full intended function
 * I could not figure out how to recursively solve this problem
 * this function instead will find if any two numbers within the array sum to the specified number.
 * I will continue to work on this and try to come up with a better solution.
 *
 * @author Andrew - Laptop
 * @version 1
 * @since 2018-05-17
 * test
 */
public class waysToSumArray {

    /**
     * this function is responsible for looking through the array and finding if two elements within
     * the array are able to sum to the desired product. I did not know how to recursively solve this to
     * answer the question exactly. instead this function will find if two numbers in the array add to the product
     *
     * @param array
     * @param number
     * @return
     */
    public static String execute(String array, String number) {

        String[] strArr = array.trim().split(",");
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.valueOf(strArr[i]);
        }

        int result = calcWays(intArr, Integer.valueOf(number));
        return String.valueOf(result);

    }

    private static int calcWays(int[] array, int sumTo) {
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
            else {
                System.out.println("No two numbers in this group add to " + sumTo);
                done = true;
            }
            if (array[arrayLength] > sumTo) {
                for (int i = 1; i < arrayLength; i++) {
                    if (array[index] + array[i] == sumTo) {
                        System.out.println(array[index] + " + " + array[i] + " is equal to " + sumTo);
                        count += 1;
                        done = true;
                    } // end if statement
                    else {
                        index += 1;
                    }
                } // end for loop
            } // end if
            else {
                System.out.println("No two numbers in this group add to " + sumTo);
                done = true;
            }
            if (array[arrayLength] == sumTo) {
                System.out.println(array[arrayLength] + " is equal to " + sumTo);
                count += 1;
                done = true;
            } // end else
        } // end while loop
        return count;
    } // end calcWays

} // end waysToSumArray
