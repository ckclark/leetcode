package leetcode.unique_paths;

public class Solution {
	public static int C(int n, int m){
		if(n - m < m) m = n - m;
		long ans = 1;
		for(int i = 1; i <= m; i++){
			ans *= n + 1 - i;
			ans /= i;
		}
		return (int)ans;
	}
	
    public int uniquePaths(int m, int n) {
    	if(m == 0 || n == 0) return 1;
    	return C(m + n - 2, n - 1);
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().uniquePaths(51, 9) + "");
    }
}
