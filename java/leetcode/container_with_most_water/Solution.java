package leetcode.container_with_most_water;

import java.util.Random;

public class Solution {
	
    public int maxArea(int[] height) {
        if(height == null || height.length <= 1) return 0;
        int n = height.length;
        int left = 0, right = n - 1;
        int max = 0;
        while(left < right){
        	int area = (right - left) * Math.min(height[right], height[left]);
        	if(area > max){
        		max = area;
        	}
        	if(height[right] > height[left]){
        		left++;
        	}else{
        		right--;
        	}
        }
        return max;
    }
    
    public static void main(String[] args){
    	final int N = 10;
    	final int bound = 100;
    	Random r = new Random();
    	int[] input = new int[N];
    	for(int i = 0; i < N; i++){
    		input[i] = r.nextInt(bound);
    		System.err.print(input[i] + " ");
    	}
    	System.err.println("");
    	int max = 0;
    	for(int i = 0; i < N; i++){
    		for(int j = 0; j < i; j++){
    			int area = (i - j) * Math.min(input[i], input[j]);
    			if(area > max)
    				max = area;
    		}
    	}
    	System.err.println(new Solution().maxArea(input));
    	System.err.println(max);
    }
}
