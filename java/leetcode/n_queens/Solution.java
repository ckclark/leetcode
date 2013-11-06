package leetcode.n_queens;

import java.util.ArrayList;

public class Solution {
	public void dfs(ArrayList<String[]> ans, char[][] board, boolean[] row, boolean[] col, boolean[] diag, boolean[] rdiag, int n, int c){
		if(c == n){
			String[] cur = new String[n];
			for(int i = 0; i < n; i++){
				cur[i] = new String(board[i]);
			}
			ans.add(cur);
		}else{
			for(int r = 0; r < n; r++){
				if(!row[r] && !col[c] && !diag[r + c] && !rdiag[r - c + n - 1]){
					row[r] = col[c] = diag[r + c] = rdiag[r - c + n - 1] = true;
					board[r][c] = 'Q';
					dfs(ans, board, row, col, diag, rdiag, n, c + 1);
					row[r] = col[c] = diag[r + c] = rdiag[r - c + n - 1] = false;
					board[r][c] = '.';
				}
			}
		}
	}
	
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> ans = new ArrayList<String[]>();
        if(n == 0){
        	ans.add(new String[0]);
        	return ans;
        }
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[2 * n - 1];
        boolean[] rdiag = new boolean[2 * n - 1];
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < n; j++){
        		board[i][j] = '.';
        	}
        }
        dfs(ans, board, row, col, diag, rdiag, n, 0);
        return ans;
    }
    
    public static void main(String[] args){
    	int cnt = 0;
    	for(String[] row : new Solution().solveNQueens(8)){
    		cnt++;
    		for(String s : row){
    			System.err.println(s);
    		}
    		System.err.println("");
    	}
    	System.err.println("cnt:" + cnt);
    }
}
