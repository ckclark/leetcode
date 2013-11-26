package leetcode.maximal_rectangle;

import java.util.Random;
import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    	int height = matrix.length;
    	int width = matrix[0].length;
    	int[][] subsum = new int[height][width];
        for(int i = 0; i < height; i++){
        	for(int j = 0; j < width; j++){
        		if(i == 0){
        			subsum[i][j] = (matrix[i][j] == '1' ? 1 : 0);
        		}else{
        			if(matrix[i][j] == '1'){
        				subsum[i][j] = subsum[i - 1][j];
        			}
        			subsum[i][j] += (matrix[i][j] == '1' ? 1 : 0);
        		}
        	}
        }
        int maxArea = 0;
        for(int i = 0; i < height; i++){
        	int area = largestRectangleArea(subsum[i]);
        	if(area > maxArea) maxArea = area;
        }
        return maxArea;
    }
    
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
    	int W = 10, H = 5;
    	char[][] matrix = new char[H][W];
    	Random r = new Random();
    	for(int i = 0; i < H; i++){
    		for(int j = 0; j < W; j++){
    			int d = r.nextInt(7);
    			if(d > 0)
    				matrix[i][j] = '1';
    			else
    				matrix[i][j] = '0';
    		}
    	}
    	for(char[] s : matrix){
    		System.err.println(s);
    	}
    	System.err.println(new Solution().maximalRectangle(matrix));
    }
}
