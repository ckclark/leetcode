package leetcode.game_of_life;

public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int w = board[0].length, h = board.length;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                int count = 0;
                for(int k = -1; k <= 1; k++){
                    for(int l = -1; l <= 1; l++){
                        if(k == 0 && l == 0){
                            continue;
                        }
                        if(i + k < 0 || i + k >= h) continue;
                        if(j + l < 0 || j + l >= w) continue;
                        if((board[i + k][j + l] & 1) != 0) count++;
                    }
                }
                if((board[i][j] & 1) == 1){
                    if(count == 2 || count == 3) board[i][j] |= 2; 
                }else{
                    if(count == 3) board[i][j] |= 2;
                }
            }
        }
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                board[i][j] >>= 1;
            }
        }
    }
}
