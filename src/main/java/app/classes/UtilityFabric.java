package app.classes;

public class UtilityFabric {
    public static String execute(String param1, String param2, String label){
         String result = null;
        switch (Integer.valueOf(label)){
            case 1 : result = Fibonacci.execute(param1);
            break;
            case 6 : result = WaysAsSumPositiveInt.execute(param1);
            break;
            case 7 : result = CoverIn3Steps.execute(param1);
            break;
            case 10 : result = PalindromicSubsequence.execute(param1);
            break;
            case 12 : result = WaysToTileFloor.execute(param1, param2);
            break;
            case 13 : result = Fence.execute(param1, param2);
            break;
            default: result = "There is no such variant in the library";
            break;
        }
        return result;

    }

}
