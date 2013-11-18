package leetcode.first_missing_positive;

public class Solution {
    public int firstMissingPositive(int[] A) {
        if(A == null || A.length == 0) return 1;
        int length = A.length;
        for(int i = 0; i < length; i++){
        	if(A[i] < 0) A[i] = 0;
        }
        for(int i = 0; i < length; i++){
        	int target = Math.abs(A[i]);
        	if(target > 0 && target <= length){
        		if(A[target - 1] == 0){
        			A[target - 1] = -target;
        		}else{
        			A[target - 1] = -Math.abs(A[target - 1]);
        		}
        	}
        }
        for(int i = 0; i < length; i++){
        	if(A[i] >= 0) return i + 1;
        }
        return length + 1;
    }
    
    
    public static void main(String[] args){
    	int[] input = new int[]{1};
    	System.err.println(new Solution().firstMissingPositive(input));
    }
}
