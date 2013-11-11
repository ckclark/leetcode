package leetcode.sudoku_solver;

public class Solution {
	public static final int N = 9;
	public boolean dfs(boolean[][] appearX, boolean[][] appearY, boolean[][] appearG, char[][] board, int x, int y){
		if(y == N){
			x++;
			y = 0;
		}
		if(x == N){
			return true;
		}
		int g = (x / 3) * 3 + (y / 3);
		if(board[x][y] != '.'){
			if(dfs(appearX, appearY, appearG, board, x, y + 1))
				return true;
		}else{
			for(int d = 0; d < N; d++){
				if(!appearX[x][d] && !appearY[y][d] && !appearG[g][d]){
					appearX[x][d] = appearY[y][d] = appearG[g][d] = true;
					board[x][y] = (char)('1' + d);
					if(dfs(appearX, appearY, appearG, board, x, y + 1))
						return true;
					board[x][y] = '.';
					appearX[x][d] = appearY[y][d] = appearG[g][d] = false;				
				}
			}
		}
		return false;
	}

    public void solveSudoku(char[][] board) {
    	boolean[][] appearX = new boolean[N][N];
    	boolean[][] appearY = new boolean[N][N];
    	boolean[][] appearG = new boolean[N][N];
    	for(int x = 0; x < N; x++){
    		for(int y = 0; y < N; y++){
    			if(board[x][y] != '.'){
    				int d = board[x][y] - '1';
    				int g = (x / 3) * 3 + (y / 3);
    				appearX[x][d] = appearY[y][d] = appearG[g][d] = true;
    			}
    		}
    	}
    	dfs(appearX, appearY, appearG, board, 0, 0);
    }

    public static void main(String[] args){
    	String[] s = new String[]{"....4.9..","..21..3..",".........","........3","...2.....",".....7...","...61....","..9......",".......9."}; 
    	char[][] board = new char[N][N];
    	for(int i = 0; i < N; i++){
    		board[i] = s[i].toCharArray();
    	}
    	new Solution().solveSudoku(board);
    	for(char[] row : board){
    		System.err.println(new String(row));
    	}
    }
}
