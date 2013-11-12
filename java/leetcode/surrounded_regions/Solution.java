package leetcode.surrounded_regions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Solution {
	public static class Position{
		public int x, y;
		public Position(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public void bfs_fill(char[][] board, int x, int y, int w, int h){
		Queue<Position> queue = new LinkedList<Position>();
		queue.offer(new Position(x, y));
		while(!queue.isEmpty()){
			Position cur = queue.remove();
			if(board[cur.x][cur.y] == 'O'){
				board[cur.x][cur.y] = '.';
				int nx, ny;
				nx = cur.x - 1;
				ny = cur.y;
				if(0 <= nx && nx < h && 0 <= ny && ny < w && board[nx][ny] == 'O'){
					queue.offer(new Position(nx, ny));
				}
				nx = cur.x;
				ny = cur.y - 1;
				if(0 <= nx && nx < h && 0 <= ny && ny < w && board[nx][ny] == 'O'){
					queue.offer(new Position(nx, ny));
				}
				nx = cur.x + 1;
				ny = cur.y;
				if(0 <= nx && nx < h && 0 <= ny && ny < w && board[nx][ny] == 'O'){
					queue.offer(new Position(nx, ny));
				}
				nx = cur.x;
				ny = cur.y + 1;
				if(0 <= nx && nx < h && 0 <= ny && ny < w && board[nx][ny] == 'O'){
					queue.offer(new Position(nx, ny));
				}
			}
		}
	}
    public void solve(char[][] board) {
    	if(board == null || board.length == 0 || board[0].length == 0) return;
    	int height = board.length;
    	int width = board[0].length;
    	for(int i = 0; i < width; i++){
    		if(board[0][i] == 'O'){
    			bfs_fill(board, 0, i, width, height);
    		}
    		if(board[height - 1][i] == 'O'){
    			bfs_fill(board, height - 1, i, width, height);
    		}
    	}
    	for(int i = 0; i < height; i++){
    		if(board[i][0] == 'O'){
    			bfs_fill(board, i, 0, width, height);
    		}
    		if(board[i][width - 1] == 'O'){
    			bfs_fill(board, i, width - 1, width, height);
    		}
    	}
    	for(int i = 0; i < height; i++){
    		for(int j = 0; j < width; j++){
    			if(board[i][j] == 'O'){
    				board[i][j] = 'X';
    			}else if(board[i][j] == '.'){
    				board[i][j] = 'O';
    			}
    		}
    	}
    }
    
    public static void dump(char[][] table){
    	for(int i = 0; i < table.length; i++){
    		System.err.println(table[i]);
    	}
    	System.err.println("");
    }
    public static void main(String[] args){
    	int w = 10, h = 8;
    	Random r = new Random();
    	char[][] table = new char[h][w];
    	for(int i = 0; i < h; i++){
    		for(int j = 0; j < w; j++){
    			if(r.nextBoolean()){
    				table[i][j] = 'O';
    			}else{
    				table[i][j] = 'X';
    			}
    		}
    	}
    	dump(table);
    	new Solution().solve(table);
    	dump(table);
    }
}
