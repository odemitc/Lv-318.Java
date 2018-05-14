package main.java.tasks;

import java.util.HashSet;
import java.util.Set;

class PalindromService {

    private boolean checkPalindrome(String word) {

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

    private Set<String> findAllPalindroms(String word) {
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

    int getMaxLengthOfPalindrom(String word) {
        return findAllPalindroms(word).stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }
}