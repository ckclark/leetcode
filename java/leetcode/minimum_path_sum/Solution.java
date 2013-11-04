package leetcode.minimum_path_sum;

public class Solution {
    public int minPathSum(int[][] grid) {
    	if(grid == null) return 0;
    	if(grid.length == 0 || grid[0].length == 0) return 0;
    	int width = grid[0].length;
    	int height = grid.length;
    	for(int i = 0; i < height; i++){
    		for(int j = 0; j < width; j++){
    			int minPath = 0;
    			if(i > 0){
    				if(j == 0){
    					minPath = grid[i - 1][j]; 
    				}else{
    					minPath = Math.min(grid[i - 1][j], grid[i][j - 1]);
    				}
    			}else{
    				if(j > 0){
    					minPath = grid[i][j - 1];
    				}
    			}
    			grid[i][j] += minPath;
    		}
    	}
    	return grid[height - 1][width - 1];
    }
}
