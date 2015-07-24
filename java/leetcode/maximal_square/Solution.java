package leetcode.maximal_square;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int h = matrix.length, w = matrix[0].length;
        int[][] maxSqrSize = new int[h][w];
        int max = 0;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(matrix[i][j] == '1'){
                    int m = 1;
                    if(i > 0 && j > 0){
                        m = Math.min(maxSqrSize[i - 1][j], maxSqrSize[i][j - 1]);
                        if(matrix[i - m][j - m] == '1'){
                            m++;
                        }
                    }
                    maxSqrSize[i][j] = m;
                    max = Math.max(m, max);
                }
            }
        }
        return max * max;
    }
}
