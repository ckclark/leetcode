package leetcode.jump_game;

public class Solution {
    public boolean canJump(int[] A) {
        if(A == null || A.length == 0) return false;
        int right = 0, cur = 0;
        while(cur <= right && right < A.length - 1){
        	if(cur + A[cur] > right)
        		right = cur + A[cur];
        	cur++;
        }
        return right >= A.length - 1;
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().canJump(new int[]{1,1,1,2,0}));
    	System.err.println(new Solution().canJump(new int[]{3,2,1,0,4}));
    }
}
