package app.classes;
/**
 * <h1>Interesting row</h1>
 * The goal: To find which is the member of position n in our interesting row.
 * @author  Iryna Holod
 * @version 1.0
 * @since   2018-05-17
 */

public class InterestingRows {

    /**
     * This method is used to provide the access
     * to private method {@link #findTheMember(int)}.
     *
     * @param str the String representation of the position og element
     * @return the String representation of the member of position n in our interesting row
     */
    public static String execute(String str){

        return findTheMember(Integer.parseInt(str));
    }

    /**
     * This method calculate which is the member of position n in our interesting row.
     * @param n the position og element
     * @return the member of position n in our interesting row
     */
    private static String findTheMember(int n) {
        if(n<0){
            return "wrong input value";
        }
        int arr[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                arr[i] = 0;
            } else if (i == 1) {
                arr[i] = 1;
            } else {
                arr[i] = arr[i - 1] + 2 * arr[i - 2];
            }
        }
        return Integer.toString(arr[n]);
    }


}
