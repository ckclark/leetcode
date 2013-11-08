package leetcode.jump_game_ii;

public class Solution {
	public int jump(int[] A) {
		if(A == null || A.length == 0) return -1;
        int size = A.length;
        int[] jumps = new int[size];
        jumps[0] = 1;
        int cur = 0;
        int R = 0;
        while(cur < size && jumps[cur] > 0 && jumps[size - 1] == 0){
        	if(cur + A[cur] > R){
        		for(int i = R + 1; i <= cur + A[cur] && i < size; i++){
        			jumps[i] = jumps[cur] + 1;
        			R = i;
        		}
        		
        	}
        	cur++;
        }
        return jumps[A.length - 1] - 1;
    }
	
	public static void main(String[] args){
		System.err.println(new Solution().jump(new int[]{1, 3, 0, 2, 0, 1}));
	}
}
