package leetcode.multiply_strings;

public class Solution {
	private static final int MODULUS = 1000000000;
	private static final int DIGITS_PER_ELE = 9;
    public String multiply(String num1, String num2) {
    	long[] bignum1 = new long[(num1.length() + 8) / 9];
    	int num1length = num1.length();
    	long[] bignum2 = new long[(num2.length() + 8) / 9];
    	int num2length = num2.length();
    	for(int i = 0; i < bignum1.length; i++){
    		bignum1[i] = Long.parseLong(num1.substring(Math.max(0, num1length - (i + 1) * DIGITS_PER_ELE), num1length - i * DIGITS_PER_ELE));
    	}
    	for(int i = 0; i < bignum2.length; i++){
    		bignum2[i] = Long.parseLong(num2.substring(Math.max(0, num2length - (i + 1) * DIGITS_PER_ELE), num2length - i * DIGITS_PER_ELE));
    	}

    	long[] result = new long[bignum1.length + bignum2.length];
    	for(int i = 0; i < bignum1.length; i++){
    		for(int j = 0; j < bignum2.length; j++){
    			result[i + j] += bignum1[i] * bignum2[j];
    		}
    	}
    	for(int i = 0; i < bignum1.length + bignum2.length - 1; i++){
    		result[i + 1] += result[i] / MODULUS;
    		result[i] %= MODULUS;
    	}
    	int idx;
    	for(idx = bignum1.length + bignum2.length - 1; idx > 0 && result[idx] == 0; idx--);
    	StringBuilder ans = new StringBuilder();
    	ans.append(String.format("%d", result[idx--]));
    	for(;idx >= 0; idx--){
    		ans.append(String.format("%09d", result[idx]));
    	}
    	return ans.toString();
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().multiply("9999999999", "9999999999"));
    }
}
