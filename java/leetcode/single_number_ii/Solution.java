package leetcode.single_number_ii;

public class Solution {
	public int singleNumber(int[] A) {
		long ans = 0;
        for(int x : A){
        	long x_ = x;
        	if(x < 0) x_ = 4294967296L + x;
        	long tmp = 0;
        	long t = 1;
        	while(x_ != 0 || ans != 0){
        		int r1 = (int) (x_ % 3);
        		int r2 = (int) (ans % 3);
        		tmp += t * ((r1 + r2) % 3);
        		x_ /= 3;
        		ans /= 3;
        		t *= 3;
        	}
        	ans = tmp;
        	
        }
        if(ans > 2147483647){
        	ans = (int)(ans - 4294967296L);
        }
        
        return (int)ans;
    }
	public static void main(String[] args){
		System.err.println("" + new Solution().singleNumber(new int[]{-401451,-177656,-2147483646,-473874,-814645,-2147483646,-852036,-457533,-401451,-473874,-401451,-216555,-917279,-457533,-852036,-457533,-177656,-2147483646,-177656,-917279,-473874,-852036,-917279,-216555,-814645,2147483645,-2147483648,2147483645,-814645,2147483645,-216555}));
	}
}
