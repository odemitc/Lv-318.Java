package app.classes;

/**
 * <h1>The longest palindromic subsequence</h1>
 *  The PalindromicSubsequence class implements method
 *  to check how many symbols has the biggest palindrome
 *  which is included in the given string.
 * @author  Stanislav Turchynskyi
 * @version 1.0
 * @since   2018-05-16
 */

public class PalindromicSubsequence {

    /**
     * This method is used to provide the access
     * to private method {@link #longestPalindrome(String)}.
     *
     * @param n the String representation of first parameter
     * @return the String representation of number of symbols in founded palindrome.
     */

    public static String execute(String n) {
        return String.valueOf(longestPalindrome(n));
    }

    /**
     * This method calculate how many symbols has the biggest palindrome
     *  which is included in the given string.
     *
     * @param enteredString entered string
     * @return number of symbols in founded palindrome.
     */

    private static int longestPalindrome(String enteredString) {
        if (enteredString == null || enteredString.length() <= 1 || enteredString.length() >= 100) {
            return 0;
        }

        int len = enteredString.length();
        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];

        String longest = null;
        for (int l = 0; l < enteredString.length(); l++) {
            for (int i = 0; i < len - l; i++) {
                int j = i + l;
                if (enteredString.charAt(i) == enteredString.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        longest = enteredString.substring(i, j + 1);
                    }
                }
            }
        }
        return longest.length();
    }
}
