package leetcode.set_matrix_zeroes;

import java.util.Random;

public class Solution {
	public void setZeroes(int[][] matrix) {
        int width = matrix[0].length;
        int height = matrix.length;
        int bottom = -1, right = -1;
        for(int i = 0; i < height; i++){
        	for(int j = 0; j < width; j++){
        		if(matrix[i][j] == 0){
        			if(i > bottom) bottom = i;
        			if(j > right) right = j;
        		}
        	}
        }
        if(bottom == -1 || right == -1) return;
        for(int i = 0; i < height; i++){
        	for(int j = 0; j < width; j++){
        		if(matrix[i][j] == 0){
        			matrix[bottom][j] = 0;
        			matrix[i][right] = 0;
        		}
        	}
        }
        
        for(int i = 0; i < height; i++){
        	if(matrix[i][right] == 0 && i != bottom){
        		for(int j = 0; j < width; j++){
        			matrix[i][j] = 0;
        		}
        	}
        }
        for(int j = 0; j < width; j++){
        	if(matrix[bottom][j] == 0){
        		for(int i = 0; i < height; i++){
        			matrix[i][j] = 0;
        		}
        	}
        }
		for(int j = 0; j < width; j++){
			matrix[bottom][j] = 0;
		}

    }
	
	public static void dumpMatrix(int[][] matrix){
		int height = matrix.length;
		int width = matrix[0].length;
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				if(matrix[i][j] == 0)
					System.err.print("*, ");
				else
					System.err.print("" + matrix[i][j] + ", ");
				
			}
			System.err.println("");
		}
		System.err.println("");
	}
	public static void main(String[] args){
		Solution sol = new Solution();
		final int width = 10, height = 9;
		int[][] matrix = new int[height][width];
		Random r = new Random();
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				matrix[i][j] = r.nextInt(10);
			}
		}
		dumpMatrix(matrix);
		System.err.println("");
		sol.setZeroes(matrix);
		dumpMatrix(matrix);
	}
}
