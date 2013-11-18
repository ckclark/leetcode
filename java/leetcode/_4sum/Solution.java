package leetcode._4sum;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    	int length = num.length;
    	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>(); 
    	Arrays.sort(num);
    	for(int i = 0; i < length; i++){
    		if(i > 0 && num[i] == num[i - 1]) continue;
    		for(int j = i + 1; j < length; j++){
    			if(j > i + 1 && num[j] == num[j - 1]) continue;
    			int head = j + 1, tail = length - 1;
        		while(head < tail){
        			while(head > j + 1 && head < tail && num[head] == num[head - 1]) head++;
        			while(tail < length - 1 && head < tail && num[tail] == num[tail + 1]) tail--;
        			int sum = num[i] + num[j] + num[head] + num[tail];
        			if(head < tail){
        				if(sum < target){
        					head++;
        				}else if(sum > target){
        					tail--;
        				}else{
        					ans.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{num[i], num[j], num[head], num[tail]})));
        					head++;
        					tail--;
        				}
        			}
        		}
    		}
    	}
    	return ans;
    }
    
    public static void main(String[] args){
    	for(ArrayList<Integer> row : new Solution().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0)){
    		for(int x : row){
    			System.err.print(x + " ");
    		}
    		System.err.println("");
    	}
    }
}
