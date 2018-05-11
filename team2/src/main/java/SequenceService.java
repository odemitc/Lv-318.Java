import java.util.ArrayList;
import java.util.List;

 class SequenceService {
    private int[] sequence;

     SequenceService(int[] sequence) {
        this.sequence = sequence;
    }

    public SequenceService setSequence(int[] sequence) {
        this.sequence = sequence;
        return this;
    }

    private List<Integer> getListOfLengths() {
        List<Integer> lengthList = new ArrayList<>();
        for (int i = 0; i < sequence.length - 1; i++) {
            lengthList.add(buildSubsequenceWithDifferenceOne(i).size());
        }
        return lengthList;
    }

    private List<Integer> buildSubsequenceWithDifferenceOne(int index) {
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

    int getMaxLengthOfSubsequence() {
        return getListOfLengths().stream().max(Integer::compareTo).orElse(0);
    }
}