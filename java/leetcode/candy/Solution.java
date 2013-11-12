package leetcode.candy;

import java.util.ArrayList;

public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        int n = ratings.length;
        ArrayList<Integer> minimals = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
        	if((i == 0 || ratings[i - 1] >= ratings[i]) && (i == n - 1 || ratings[i + 1] >= ratings[i])){
        		minimals.add(i);
        	}
        }
        int[] candies = new int[n];
        for(int minimal : minimals){
        	candies[minimal] = 1;
        	for(int i = minimal + 1; i < n && ratings[i] > ratings[i - 1]; i++){
        		if(candies[i] < candies[i - 1] + 1){
        			candies[i] = candies[i - 1] + 1;
        		}
        	}
        	for(int i = minimal - 1; i >= 0 && ratings[i] > ratings[i + 1]; i--){
        		if(candies[i] < candies[i + 1] + 1){
        			candies[i] = candies[i + 1] + 1;
        		}
        	}
        }
        int sum = 0;
        for(int x : candies){
        	sum += x;
        }
        return sum;
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().candy(new int[]{-1, 0, 1, 2, 3, 4, 4, 2, 1, 0}));
    }
}
