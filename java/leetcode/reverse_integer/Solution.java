package leetcode.reverse_integer;

public class Solution {
    public int reverse(int x) {
    	int ret = 0;
    	while(x != 0){
    		ret *= 10;
    		ret += x % 10;
    		x /= 10;
    	}
    	return ret;
    }
    public static void main(String[] args){
    	System.err.println("" + new Solution().reverse(1234));
    	System.err.println("" + new Solution().reverse(1000));
    	System.err.println("" + new Solution().reverse(-1234));
    }
}
