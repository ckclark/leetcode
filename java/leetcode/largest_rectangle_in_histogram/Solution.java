package leetcode.largest_rectangle_in_histogram;

import java.util.Stack;


public class Solution {
	public static class Histogram{
		int offset, height;
		public Histogram(int offset, int height){
			this.offset = offset;
			this.height = height;
		}
	}
    public int largestRectangleArea(int[] height) {
    	Stack<Histogram> stack = new Stack<Histogram>();
    	int length = height.length;
    	int max = 0;
    	for(int i = 0; i < length; i++){
    		int left = i;
    		while(!stack.isEmpty() && stack.peek().height >= height[i]){
    			Histogram hist = stack.pop();
    			int area = hist.height * (i - hist.offset);
    			left = hist.offset;
    			if(area > max) max = area;
    		}
    		stack.push(new Histogram(left, height[i]));
    	}
    	while(!stack.isEmpty()){
			Histogram hist = stack.pop();
			int area = hist.height * (length - hist.offset);
			if(area > max) max = area;
    	}
    	return max;
    }
    public static void main(String[] args){
    	System.err.println(new Solution().largestRectangleArea(new int[]{1,1,1,1,1,2,9,8,8, 5, 5}));
    }
}
