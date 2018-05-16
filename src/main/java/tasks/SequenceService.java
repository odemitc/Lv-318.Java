package tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * Util class for calculating length of the longest subsequence with difference one
 *
 * @author Pavlo Chornyi
 * @version 1.0 16 May 2018
 */
public class SequenceService {
    /**
     * Static method for calculating length of the longest subsequence
     *
     * @param sequence - array of integer, our sequence to check
     * @return length of the longest subsequence with difference one
     */
    public static int getMaxLengthOfSubsequence(int[] sequence) {
        return getListOfLengths(sequence).stream().max(Integer::compareTo).orElse(0);
    }

    /**
     * private util method to make a list of lengths our subsequences
     *
     * @param sequence - array of integer, our sequence to check
     * @return a list of lengths our subsequences
     */
    private static List<Integer> getListOfLengths(int[] sequence) {
        List<Integer> lengthList = new ArrayList<>();
        for (int i = 0; i < sequence.length - 1; i++) {
            lengthList.add(buildSubsequenceWithDifferenceOne(i, sequence).size());
        }
        return lengthList;
    }

    /**
     * private util method to build subsequence with difference 1
     *
     * @param index     -integer index to start checking condition( difference 1)
     * @param sequence- array of integer, our sequence to check
     * @return list of subsequences
     */
    private static List<Integer> buildSubsequenceWithDifferenceOne(int index, int[] sequence) {
        List<Integer> subsequence = new ArrayList<>();
        while (index < sequence.length - 1) {
            if ((sequence[index] == sequence[index + 1] + 1) ||
                    (sequence[index] == sequence[index + 1] - 1)) {
                subsequence.add(sequence[index]);
            }
            index++;
        }
        return subsequence;
    }


}