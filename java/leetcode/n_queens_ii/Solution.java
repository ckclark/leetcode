package leetcode.n_queens_ii;

public class Solution {
	public int dfs(boolean[] row, boolean[] col, boolean[] diag, boolean[] rdiag, int n, int c){
		if(c == n){
			return 1;
		}else{
			int ans = 0;
			for(int r = 0; r < n; r++){
				if(!row[r] && !col[c] && !diag[r + c] && !rdiag[r - c + n - 1]){
					row[r] = col[c] = diag[r + c] = rdiag[r - c + n - 1] = true;
					ans += dfs(row, col, diag, rdiag, n, c + 1);
					row[r] = col[c] = diag[r + c] = rdiag[r - c + n - 1] = false;
				}
			}
			return ans;
		}
	}
	
	public int totalNQueens(int n) {
		if(n == 0) return 1;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[2 * n - 1];
        boolean[] rdiag = new boolean[2 * n - 1];
        return dfs(row, col, diag, rdiag, n, 0);
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().totalNQueens(12));
    }
}
