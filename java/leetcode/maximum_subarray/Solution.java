package leetcode.maximum_subarray;

public class Solution {
    public int maxSubArray(int[] A) {
        if(A == null) return 0;
        if(A.length == 0) return 0;
        int max = A[0];
        int cur = 0;
        for(int x : A){
        	if(cur > 0){
        		cur += x;
        	}else{
        		cur = x;
        	}
        	if(cur > max){
        		max = cur;
        	}
        }
        return max;
    }
    
    public static void main(String[] args){
    	System.err.println("" + new Solution().maxSubArray(new int[]{-1, 3, 2, 5, -9, 8, 9}));
    }
}
