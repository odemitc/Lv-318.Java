package tasks;

import java.util.HashSet;
import java.util.Set;

/**
 * Util class for calculating how many symbols has the biggest palindrome which is included in the given one.
 *
 * @author Pavlo Chornyi
 * @version 1.0 16 May 2018
 */
public class PalindromService {
    /**
     * Static method for calculating how many symbols has the biggest palindrome in the word
     *
     * @param word - String word to search the longest palindrom
     * @return integer value of lenght the longest palindrom in a word
     */
    public static int getMaxLengthOfPalindrom(String word) {
        return findAllPalindroms(word).stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    /**
     * private util method to check that this word is a palindrom
     *
     * @param word - String word to check
     * @return boolean value that this word is a palindrom or not
     */
    private static boolean checkPalindrome(String word) {

        int i = 0;
        int j = word.length() - 1;
        while (i <= j) {
            if (word.charAt(i) != word.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    /**
     * private util method to finde all palindroms in a word
     *
     * @param word - String word to search all palindroms
     * @return Set of palindroms from a word
     */
    private static Set<String> findAllPalindroms(String word) {
        Set<String> palindromSet = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            for (int j = word.length(); j >= i; j--) {
                if (checkPalindrome(word.substring(i, j))) {
                    palindromSet.add(word.substring(i, j));
                }
            }
        }
        return palindromSet;
    }


}