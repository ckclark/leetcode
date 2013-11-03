package leetcode.search_insert_position;

public class Solution {
    public int searchInsert(int[] A, int target) {
    	if(A == null) return 0;
    	if(A.length == 0) return 0;
    	int U = A.length;
    	int L = 0;
    	if(target <= A[0]) return 0;
    	while(L + 1 < U){
    		int mid = (L + U) / 2;
    		if(A[mid] == target) return mid;
    		if(A[mid] > target){
    			U = mid;
    		}else{
    			L = mid;
    		}
    	}
    	return U;
    }
    
    public static void main(String[] args){
    	System.err.println("" + new Solution().searchInsert(new int[]{1, 2, 3, 5}, 0));
    	System.err.println("" + new Solution().searchInsert(new int[]{1, 2, 3, 5}, 1));
    	System.err.println("" + new Solution().searchInsert(new int[]{1, 2, 3, 5}, 2));
    	System.err.println("" + new Solution().searchInsert(new int[]{1, 2, 3, 5}, 3));
    	System.err.println("" + new Solution().searchInsert(new int[]{1, 2, 3, 5}, 4));
    	System.err.println("" + new Solution().searchInsert(new int[]{1, 2, 3, 5}, 5));
    	System.err.println("" + new Solution().searchInsert(new int[]{1, 2, 3, 5}, 6));
    }
}
