package leetcode.factorial_trailing_zeroes;

public class Solution {
    public int trailingZeroes(int n) {
        int ret = 0;
        while(n > 0){
        	ret += n / 5;
        	n /= 5;
        }
        return ret;
    }
    public static void main(String[] args){
    	System.err.println(new Solution().trailingZeroes(100));
    }
}
