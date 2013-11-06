package leetcode.next_permutation;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] num) {
    	if(num == null || num.length == 0) return;
    	int idx;
    	for(idx = num.length - 2; idx >= 0 && num[idx + 1] <= num[idx]; idx--);
    	if(idx < 0){
    		Arrays.sort(num);
    	}else{
    		int nextIdx = idx + 1;
    		for(int i = idx + 1; i < num.length && num[i] > num[idx]; i++){
    			nextIdx = i;
    		}
    		int tmp = num[idx];
    		num[idx] = num[nextIdx];
    		num[nextIdx] = tmp;
    		for(int i = 0; i < (num.length - (idx + 1)) / 2; i++){
    			tmp = num[idx + 1 + i]; 
    			num[idx + 1 + i] = num[num.length - 1 - i];
    			num[num.length - 1 - i] = tmp;
    		}
    	}
    }
    
    public static void main(String[] args){
    	int[] ary = new int[]{};
    	for(int i = 0; i < 120; i++){
    		new Solution().nextPermutation(ary);
    		for(int j = 0; j < ary.length; j++){
    			System.err.print(ary[j] + ", ");
    		}
    		System.err.println("");
    	}
    }
}
