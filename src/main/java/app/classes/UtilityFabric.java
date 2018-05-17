package app.classes;

import com.sun.org.apache.xpath.internal.operations.Mod;

public class UtilityFabric {

    public static String execute(String param1, String param2, String label) {
        String result = null;
        switch (Integer.valueOf(label)) {
            case 1:
                result = Fibonacci.execute(param1);
                break;
            case 2:
                result = ModificationFibonachi.execute(param1);
                break;
            case 3:
                result = InterestingRows.execute(param1);
                break;
            case 4:
                result = LongSubWithDifOne.execute(param1);
                break;
            case 6:
                result = WaysAsSumPositiveInt.execute(param1);
                break;
            case 7:
                result = CoverIn3Steps.execute(param1);
                break;
            case 8:
                result = pathsWithoutCrossing.execute(param1);
                break;
            case 9:
                result = HighLowEfforts.execute(param1, param2);
                break;
            case 10:
                result = PalindromicSubsequence.execute(param1);
                break;
            case 11:
                result = FriendPairs.execute(param1);
                break;
            case 12:
                result = WaysToTileFloor.execute(param1, param2);
                break;
            case 13:
                result = Fence.execute(param1, param2);
                break;
            case 14:
                result = OptimizedFence.execute(param1, param2);
                break;
            default:
                result = "There is no such variant in the library";
                break;
        }
        return result;
    }
}
