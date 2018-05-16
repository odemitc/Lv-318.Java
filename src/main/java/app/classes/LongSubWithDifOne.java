package app.classes;

public class LongSubWithDifOne {
    // input String "2 3 4 5 11 12 13 14 15 16 17 18"
    public static String execute(String str) {


        return longestSubseqWithDiffOne(str);
    }

    static String longestSubseqWithDiffOne(String str) {
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

