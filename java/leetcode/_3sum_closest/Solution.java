package leetcode._3sum_closest;

import java.util.Arrays;

public class Solution {
	
    public int threeSumClosest(int[] num, int target) {
    	Arrays.sort(num);
    	int length = num.length;
    	int ans = num[0] + num[1] + num[2];
    	int mindiff = target - ans;
    	for(int i = 0; i < length; i++){
    		int head = i + 1, tail = length - 1;
    		while(head < tail){
    			int sum = num[i] + num[head] + num[tail];
    			int diff = target - sum;
    			if(Math.abs(diff) < mindiff){
    				mindiff = Math.abs(diff);
    				ans = sum;
    			}
    			if(diff > 0){
    				head++;
    			}else if(diff < 0){
    				tail--;
    			}else{
    				return target;
    			}
    		}
    	}
    	return ans;
    }
    
    public static void main(String[] args){
    	int[] input = new int[]{1, 2, 3};
    	System.err.println(new Solution().threeSumClosest(input, 0));
    }
}
