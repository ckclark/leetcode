package leetcode.powx_n;

public class Solution {
    public double pow(double x, long n) {
    	if(x == 0){
    		if(n == 0) return Double.NaN;
    		else return 0;
    	}else{
    		if(n < 0){
    			return 1 / pow(x, -n);
    		}else if(n > 0){
    			if(n % 2 == 0){
    				double tmp = pow(x, n / 2);
    				return tmp * tmp;
    			}else{
    				double tmp = pow(x, n - 1);
    				return tmp * x;
    			}
    		}else{
    			return 1;
    		}
    	}
    }
    public double pow(double x, int n){
    	return pow(x, (long)n);
    }

    public static void main(String[] args){
    	double x = 1.;
    	long n = -2147483648;
    	System.err.println(new Solution().pow(x, n));
    }
}
