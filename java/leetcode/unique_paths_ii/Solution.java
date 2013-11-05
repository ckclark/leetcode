package leetcode.unique_paths_ii;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
    	int height = obstacleGrid.length;
    	int width = obstacleGrid[0].length;
    	if(obstacleGrid[0][0] > 0) return 0;
    	if(obstacleGrid[height - 1][width - 1] > 0) return 0;
    	obstacleGrid[0][0] = -1;
    	for(int i = 0; i < height; i++){
    		for(int j = 0; j < width; j++){
    			if(obstacleGrid[i][j] == 0){
	    			if(i > 0){
	    				if(obstacleGrid[i - 1][j] <= 0){
	    					obstacleGrid[i][j] += obstacleGrid[i - 1][j];
	    				}
	    			}
	    			if(j > 0){
	    				if(obstacleGrid[i][j - 1] <= 0){
	    					obstacleGrid[i][j] += obstacleGrid[i][j - 1];
	    				}
	    			}
    			}
    		}
    	}
    	return -obstacleGrid[height - 1][width - 1];
    }
    
    public static void main(String[] args){
    	int[][] map = new int[3][3];
    	map[0][0] = 1;
    	System.err.println(new Solution().uniquePathsWithObstacles(map) + "");
    }
}
