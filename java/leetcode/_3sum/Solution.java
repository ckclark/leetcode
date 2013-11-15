package leetcode._3sum;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
       	Arrays.sort(num);
       	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    	int length = num.length;
    	for(int i = 0; i < length; i++){
    		if(i > 0 && num[i] == num[i - 1]) continue;
    		int head = i + 1, tail = length - 1;
    		while(head < tail){
    			int sum = num[i] + num[head] + num[tail];
    			if(sum < 0){
    				head++;
    				while(head < tail && num[head] == num[head - 1]) head++;
    			}else if(sum > 0){
    				tail--;
    				while(head < tail && num[tail] == num[tail + 1]) tail--;
    			}else{
    				ans.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{num[i], num[head], num[tail]})));
    				head++;
    				tail--;
    				while(head < tail && num[head] == num[head - 1]) head++;
    				while(head < tail && num[tail] == num[tail + 1]) tail--;
    			}
    		}
    	}
    	return ans;        
    }
    
    
    public static void main(String[] args){
    	for(ArrayList<Integer> row : new Solution().threeSum(new int[]{-1, -1, -1, -1, 0, 0, 0, 1, 1, 1, 2, 2, 2, -4, -4, -4 , 0, 1, 2, -1, -4,})){
    		for(int x : row){
    			System.err.print(x + " ");
    		}
    		System.err.println("");
    	}
    }
}
