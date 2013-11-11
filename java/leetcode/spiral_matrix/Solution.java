package leetcode.spiral_matrix;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
    	ArrayList<Integer> ans = new ArrayList<Integer>();
    	if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return ans; 
    	int height = matrix.length;
    	int width = matrix[0].length;
    	
        int x = 0, y = 0;
        ans.add(matrix[x][y]);
        int boundl = -1, boundr = width;
        int boundu = -1, boundd = height;
        while(boundl <= boundr && boundu <= boundd){
        	while(y + 1 < boundr){
        		ans.add(matrix[x][y + 1]);
        		y++;
        	}
        	boundu++;
        	if(boundu + 1 == boundd) break;
        	while(x + 1 < boundd){
        		ans.add(matrix[x + 1][y]);
        		x++;
        	}
        	boundr--;
        	if(boundr - 1 == boundl) break;
        	while(y - 1 > boundl){
        		ans.add(matrix[x][y - 1]);
        		y--;
        	}
        	boundd--;
        	if(boundd - 1 == boundu) break;
        	while(x - 1 > boundu){
        		ans.add(matrix[x - 1][y]);
        		x--;
        	}
        	boundl++;
        	if(boundl + 1 == boundr) break;
        }
        return ans;
    }
    
    public static void main(String[] args){
    	final int W = 3, H = 3;
    	int[][] matrix = new int[H][W];
    	for(int i = 0; i < H; i++){
    		for(int j = 0; j < W; j++){
    			matrix[i][j] = i * W + j;
    		}
    	}
    	
    	for(int x : new Solution().spiralOrder(matrix)){
    		System.err.print(x + " ");
    	}
    	System.err.println("");
    }
}
