package leetcode.rotate_image;

public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null) return;
        if(matrix.length == 0) return;
        int size = matrix.length;
        for(int i = 0; i < (size + 1) / 2; i++){
        	for(int j = 0; j < size / 2; j++){
        		int tmp;
        		tmp = matrix[i][j];
        		matrix[i][j] = matrix[size - 1 - j][i];
        		matrix[size - 1 - j][i] = matrix[size - 1 - i][size - 1 - j];
        		matrix[size - 1 - i][size - 1 - j] = matrix[j][size - 1 - i];
        		matrix[j][size - 1 - i] = tmp;
        	}
        }
    }
    
    public static void main(String[] args){
    	final int N = 5;
    	int[][] matrix = new int[N][];
    	for(int i = 0; i < N; i++){
    		matrix[i] = new int[N];
    		for(int j = 0; j < N; j++){
    			matrix[i][j] = i * N + j;
    		}
    	}
    	new Solution().rotate(matrix);
    	for(int i = 0; i < N; i++){
    		for(int j = 0; j < N; j++){
    			System.err.print(matrix[i][j] + ", ");
    		}
    		System.err.println("");
    	}
    }
}
