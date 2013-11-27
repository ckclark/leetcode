package leetcode.word_search;

import java.util.Stack;

public class Solution {
	private int H, W;
	public static class State{
		int x, y, depth;
		boolean restore;
		public State(int x, int y, int depth){
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
	public boolean dfs(char[][] board, int sx, int sy, char[] chars){
		Stack<State> stack = new Stack<State>();
		stack.push(new State(sx, sy, 0));
		while(!stack.isEmpty()){
			State current = stack.peek();
			if(current.restore){
				board[current.x][current.y] = chars[current.depth];
				stack.pop();
				continue;
			}else{
				current.restore = true;
			}
			int x = current.x;
			int y = current.y;
			int depth = current.depth;
			if(depth + 1 == chars.length) return true;
			board[x][y] = 0;
			int nx, ny;
			nx = x - 1;
			ny = y;
			if(0 <= nx && nx < H && 0 <= ny && ny < W && chars[depth + 1] == board[nx][ny]){
				stack.push(new State(nx, ny, depth + 1));
			}
			nx = x + 1;
			ny = y;
			if(0 <= nx && nx < H && 0 <= ny && ny < W && chars[depth + 1] == board[nx][ny]){
				stack.push(new State(nx, ny, depth + 1));
			}
			nx = x;
			ny = y - 1;
			if(0 <= nx && nx < H && 0 <= ny && ny < W && chars[depth + 1] == board[nx][ny]){
				stack.push(new State(nx, ny, depth + 1));
			}
			nx = x;
			ny = y + 1;
			if(0 <= nx && nx < H && 0 <= ny && ny < W && chars[depth + 1] == board[nx][ny]){
				stack.push(new State(nx, ny, depth + 1));
			}
		}
		return false;
	}
	
    public boolean exist(char[][] board, String word) {
    	char[] chars = word.toCharArray();
    	char first = chars[0];
    	
    	H = board.length;
    	W = board[0].length;
    	for(int i = 0; i < H; i++){
    		for(int j = 0; j < W; j++){
    			if(board[i][j] == first){
    				if(dfs(board, i, j, chars)){
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args){
    	char[][] board = new char[][]{"aa".toCharArray()};
    	System.err.println(new Solution().exist(board, "aaa"));
    }
}
