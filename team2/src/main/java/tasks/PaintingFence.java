package tasks;

public class PaintingFence {
	public int countWays(int n, int k) {
		int same=0;
		int different = k;
		for(int i=2; i<=n; i++) {
			int tmp = different;
			different = (same+different)*(k-1);
			same=tmp;
		}
		return same+different;
	}

}