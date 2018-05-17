package app.classes;
/**
 * <h1>Modification Fibonacci</h1>
 * To find which is the member of position n in Modification Fibonacci sequence.
 * @author  Iryna Holod
 * @version 1.0
 * @since   2018-05-17
 */

public class ModificationFibonachi {
    /**
     * This method is used to provide the access
     * to private method {@link #findTheMember(int)}.
     *
     * @param str the String representation of the position og element
     * @return the String representation of the member of position n in Modification Fibonacci sequence
     */
    public static String execute(String str){

        return findTheMember(Integer.parseInt(str));
    }
    /**
     * This method calculate which is the member of position n in Modification Fibonacci sequence.
     * @param n the position og element
     * @return the member of position n in  Modification Fibonacci sequence
     */
    public static String findTheMember(int n) {

        if(n<0){
            return "wrong input value";
        }

        int arr[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0||i==1||i==2) {
                arr[i] = 1;
            } else {
                arr[i] = arr[i - 1] +  arr[i - 3];
            }
        }
        return Integer.toString(arr[n-1]);
    }

}
