package leetcode.permutation_sequence;

import java.util.ArrayList;

public class Solution {
	public final int[] FACTORIAL = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
	
    public String getPermutation(int n, int k) {
    	k--;
    	ArrayList<Integer> digits = new ArrayList<Integer>();
    	for(int i = 1; i <= n; i++)
    		digits.add(i);
    	ArrayList<Integer> ans = new ArrayList<Integer>(); //getPermutation(digits, k - 1);
    	
    	for(int i = 0; i < n; i++){
    		if(k == 0){
    			ans.addAll(digits);
    			break;
    		}else{
    			int remove = k / FACTORIAL[digits.size() - 1];
    			int rem = k % FACTORIAL[digits.size() - 1];
    			ans.add(digits.remove(remove));
    			k = rem;
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int x : ans){
    		sb.append(x);
    	}
    	return sb.toString();
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().getPermutation(2, 1));
    	System.err.println(new Solution().getPermutation(2, 2));
    	for(int i = 1; i <= 720; i++){
    		System.err.println(new Solution().getPermutation(6, i));
    	}
    }
}
