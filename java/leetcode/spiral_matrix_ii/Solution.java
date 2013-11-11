package leetcode.spiral_matrix_ii;


public class Solution {
    public int[][] generateMatrix(int n) {
    	int[][] ans = new int[n][n];
    	if(n == 0) return ans;
    	int height = n;
    	int width = n;
    	int number = 1;
        int x = 0, y = 0;
        ans[0][0] = number++;
        int boundl = -1, boundr = width;
        int boundu = -1, boundd = height;
        while(boundl <= boundr && boundu <= boundd){
        	while(y + 1 < boundr){
        		ans[x][y + 1] = number++;
        		y++;
        	}
        	boundu++;
        	if(boundu + 1 == boundd) break;
        	while(x + 1 < boundd){
        		ans[x + 1][y] = number++;
        		x++;
        	}
        	boundr--;
        	if(boundr - 1 == boundl) break;
        	while(y - 1 > boundl){
        		ans[x][y - 1] = number++;
        		y--;
        	}
        	boundd--;
        	if(boundd - 1 == boundu) break;
        	while(x - 1 > boundu){
        		ans[x - 1][y] = number++;
        		x--;
        	}
        	boundl++;
        	if(boundl + 1 == boundr) break;
        }
    	return ans;
    }
    
    public static void main(String[] args){
    	int[][] ans = new Solution().generateMatrix(10);
    	for(int[] x : ans){
    		for(int y : x){
    			System.err.print(y + " ");
    		}
    		System.err.println("");
    	}
    }
}
