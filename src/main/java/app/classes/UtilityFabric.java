package app.classes;

public class UtilityFabric {
    public static String execute(String param, String label){
         String result = null;
        switch (Integer.valueOf(label)){
            case 1 : result = Fibonacci.execute(param);
            break;
            case 2 : result = "";
            break;
            case 10 : result = PalindromicSubsequence.execute(param);
            break;
            default: result = "There is no such variant in the library";
            break;
        }
        return result;

    }

    public static String execute(String param, String param2, String label){
        String result = null;
        switch (Integer.valueOf(label)){
            case 1 : result = "";
                break;
            case 2 : result = "";
                break;
            default: result = "There is no such variant in the library";
                break;
        }
        return result;

    }

}
