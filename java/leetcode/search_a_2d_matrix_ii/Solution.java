package leetcode.search_a_2d_matrix_ii;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int L = 0, U = 0, R = matrix[0].length, D = matrix.length;
    	return searchMatrixInternal(matrix, L, R, U, D, target);
    }
    
    public boolean searchMatrixInternal(int[][] matrix, int L, int R, int U, int D, int target) {
        if(L == R || U == D)
        	return false;
        int m = U + (D - U) / 2; 
        int lower = L - 1, upper = R;
        while(lower + 1 < upper){
        	int mid = lower + (upper - lower) / 2;
        	if(matrix[m][mid] == target){
        		return true;
        	}else if(matrix[m][mid] < target){
        		lower = mid;
        	}else{
        		upper = mid;
        	}
        }
        return searchMatrixInternal(matrix, L, upper, m + 1, D, target) || searchMatrixInternal(matrix, upper, R, U, m, target);
    }
}