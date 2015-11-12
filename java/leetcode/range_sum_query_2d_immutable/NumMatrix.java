package leetcode.range_sum_query_2d_immutable;

public class NumMatrix {
    
    private int[][] subsum;

    public NumMatrix(int[][] matrix) {
        if(matrix != null && matrix.length > 0){
            subsum = new int[matrix.length + 1][matrix[0].length + 1];
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[0].length; j++){
                    subsum[i + 1][j + 1] = subsum[i + 1][j] + matrix[i][j];
                }
            }
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[0].length; j++){
                    subsum[i + 1][j + 1] += subsum[i][j + 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return subsum[row2 + 1][col2 + 1] - subsum[row1][col2 + 1] - subsum[row2 + 1][col1] + subsum[row1][col1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
