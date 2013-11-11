package leetcode.sqrtx;

public class Solution {
	public int sqrt(int x) {
		int U = 46341; // int(sqrt(2147483647))
		int L = -1;
		while(L < U - 1){
			int mid = (U + L) / 2;
			if(mid * mid > x){
				U = mid;
			}else if(mid * mid < x){
				L = mid;
			}else
				return mid;
		}
		return L;
    }
	
	public static void main(String[] args){
		System.err.println(new Solution().sqrt(1 << 30));
		System.err.println(new Solution().sqrt(0));
		System.err.println(new Solution().sqrt(1));
		System.err.println(new Solution().sqrt(2));
		System.err.println(new Solution().sqrt(3));
		System.err.println(new Solution().sqrt(4));
	}
}
