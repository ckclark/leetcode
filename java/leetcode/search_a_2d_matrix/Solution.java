package leetcode.search_a_2d_matrix;

public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null) return false;
		if(matrix.length == 0) return false;
		if(matrix[0].length== 0) return false;
		int height = matrix.length;
		int width = matrix[0].length;
		int U = height * width;
		int L = 0;
		if(matrix[0][0] == target) return true;
		if(matrix[0][0] > target || matrix[height - 1][width - 1] < target) return false;
		while(L + 1 < U){
			int mid = (L + U) / 2;
			int x = mid / width;
			int y = mid % width;
			if(matrix[x][y] == target) return true;
			if(matrix[x][y] > target) U = mid;
			else L = mid;
		}
		return false;
    }
	
	public static void main(String[] args){
		final int height = 5;
		final int width = 3;
		int[][] matrix = new int[height][width];
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				matrix[i][j] = (i * width + j) * 2;
			}
		}
		for(int i = -1; i < (height * width) * 2 + 1; i++){
			System.err.println("" + new Solution().searchMatrix(matrix, i));
		}
	}
}
