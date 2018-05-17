package app.classes;
/**
 * <h1>Longest subsequence with difference one</h1>
 * The goal: To find how many numbers we have with difference one in the maximum sub sequence.
 * @author  Iryna Holod
 * @version 1.0
 * @since   2018-05-17
 */

public class LongSubWithDifOne {
    /**
     * This method is used to provide the access
     * to private method {@link #longestSubseqWithDiffOne(String)}.
     *
     * @param str the String representation of sequence with integer numbers
     * @return the String representation of quantity of numbers we have with difference one in the maximum sub sequence
     */
    // input String "2 3 4 5 11 12 13 14 15 16 17 18"
    public static String execute(String str) {
        return longestSubseqWithDiffOne(str);
    }


      /**
       * This method calculate how many numbers we have with difference one in the maximum sub sequence.
       * @param str the sequence with integer numbers
       * @return the  quantity of numbers we have with difference one in the maximum sub sequence
       */
      private static String longestSubseqWithDiffOne(String str) {
        if (str.length() == 0 || str.trim().length() == 0) {
            return "wrong iput value";
        }

        String strArr[] = str.split(" ");
        int arr[] = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        int n = arr.length;
        int count = 0;
        int temp1 = 0;
        int temp2 = 0;

        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                if ((arr[j - 1] == arr[j] - 1)) {
                    count++;
                    temp1 = count;

                    if (temp1 > temp2) {
                        temp2 = temp1;
                    }
                } else {
                    count = 0;
                    i = j;

                }
                break;

            }

        }
        return Integer.toString(temp2 + 1);
    }


}

