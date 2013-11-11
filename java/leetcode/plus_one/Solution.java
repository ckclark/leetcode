package leetcode.plus_one;

public class Solution {
    public int[] plusOne(int[] digits) {
    	int carry = 1;
    	for(int i = digits.length - 1; i >= 0; i--){
    		digits[i] += carry;
    		carry = digits[i] / 10;
    		if(digits[i] >= 10){
    			digits[i] %= 10;
    		}else{
    			break;
    		}
    	}
    	if(carry > 0){
    		int[] ans = new int[digits.length + 1];
    		for(int i = 1; i < ans.length; i++){
    			ans[i] = digits[i - 1];
    		}
    		ans[0] = carry;
    		return ans;
    	}
    	return digits;
    }
    
    public static void main(String[] args){
    	int[] ans = new Solution().plusOne(new int[]{0});
    	for(int i = 0; i < ans.length; i++)
    		System.err.print(ans[i]);
    }
}
