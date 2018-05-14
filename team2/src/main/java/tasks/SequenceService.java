package java.tasks;

import java.util.ArrayList;
import java.util.List;

class SequenceService {

    private List<Integer> getListOfLengths(int[] sequence) {
        List<Integer> lengthList = new ArrayList<>();
        for (int i = 0; i < sequence.length - 1; i++) {
            lengthList.add(buildSubsequenceWithDifferenceOne(i, sequence).size());
        }
        return lengthList;
    }

    private List<Integer> buildSubsequenceWithDifferenceOne(int index, int[] sequence) {
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

    int getMaxLengthOfSubsequence(int[] sequence) {
        return getListOfLengths(sequence).stream().max(Integer::compareTo).orElse(0);
    }
}