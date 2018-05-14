package tasks;

public class LowHightEfforts {

	public int maxAmountTasks(int days, int lowTasks [], int hightTasks []) {
		int maxAmount=0;
		if(days==0) {
			return 0;
		}
		for(int i=1; i<=days; i++) {
			if(((i-1)==0)||(hightTasks[i-1]==0)) {
				maxAmount=maxAmount+hightTasks[i-1];
			}
			else {
				maxAmount=maxAmount+lowTasks[i-1];
			}
		}
		return maxAmount;
	}
}
