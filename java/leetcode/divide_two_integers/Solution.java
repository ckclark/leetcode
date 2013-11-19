package leetcode.divide_two_integers;

public class Solution {
    public int divide(int dividend, int divisor) {
    	long dividend_l = (long)dividend;
    	long divisor_l = (long)divisor;
    	long rem = 0;
    	long ans = 0;
    	boolean negative = false;
    	if(dividend_l < 0 && divisor_l < 0){
    		dividend_l = -dividend_l;
    		divisor_l = -divisor_l;
    	}else{
    		if(dividend_l < 0){
    			dividend_l = -dividend_l;
    			negative = true;
    		}
    		if(divisor_l < 0){
    			divisor_l = -divisor_l;
    			negative = true;
    		}
    	}
    	for(int t = 32; t >= 0; t--){
    		rem <<= 1;
    		rem |= (((1L << t) & dividend_l) == 0 ? 0 : 1);
    		ans <<= 1;
    		if(rem >= divisor_l){
    			ans += 1;
    			rem -= divisor_l;
    		}
    	}
    	if(negative){
    		ans = -ans;
    	}
    	return (int)ans;
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().divide(-2147483648, -2147483648));
    }
}
