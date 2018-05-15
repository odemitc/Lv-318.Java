package app.classes;

public class HightLowEfforts {
    public static String execute(String strLowTasks, String strHighTasks) {
        return Integer.toString(maxAmountTasks(strLowTasks, strHighTasks));
    }

    public static int maxAmountTasks(String strLowTasks, String strHighTasks) {


        String temp1[] = strHighTasks.split(" ");
        String temp2[] = strLowTasks.split(" ");
        int days = Math.max(temp1.length, temp2.length);


        int hightTasks[] = new int[days];
        for (int i = 0; i < days; i++) {
            if (i == temp1.length) {
                hightTasks[i] = 0;
            } else {
                hightTasks[i] = Integer.parseInt(temp1[i]);
            }


        }


        int lowTasks[] = new int[days];
        for (int i = 0; i < days; i++) {
            if (i == temp2.length) {
                lowTasks[i] = 0;
            } else {
                lowTasks[i] = Integer.parseInt(temp2[i]);
            }

        }

        int maxAmount = hightTasks[0];

        if (days == 0) {
            return 0;
        }
        for (int i = 2; i < hightTasks.length; i += 2) {
            for (int j = i; j < lowTasks.length; j += 2) {
                if (lowTasks[j - 1] + lowTasks[j] > hightTasks[i]) {
                    maxAmount += (lowTasks[j - 1] + lowTasks[j]);

                    break;
                } else {
                    maxAmount += hightTasks[i];

                    break;

                }

            }


        }
        return maxAmount;
    }


}
