package leetcode.valid_sudoku;

public class Solution {
	public static final int N = 9;

    public boolean isValidSudoku(char[][] board) {
    	boolean[][] appearX = new boolean[N][N];
    	boolean[][] appearY = new boolean[N][N];
    	boolean[][] appearG = new boolean[N][N];
    	for(int x = 0; x < N; x++){
    		for(int y = 0; y < N; y++){
    			if(board[x][y] != '.'){
    				int d = board[x][y] - '1';
    				int g = (x / 3) * 3 + (y / 3);
    				if(appearX[x][d] || appearY[y][d] || appearG[g][d]) return false;
    				appearX[x][d] = appearY[y][d] = appearG[g][d] = true;
    			}
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args){
    	String[] s = new String[]{"....4.9..","..21..3..",".........","........3","...2.....",".....7...","...61....","..9......",".......9."}; 
    	char[][] board = new char[N][N];
    	for(int i = 0; i < N; i++){
    		board[i] = s[i].toCharArray();
    	}
    	System.err.println(new Solution().isValidSudoku(board) + "");
    }
}
