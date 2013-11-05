package leetcode.search_for_a_range;

public class Solution {
    public int[] searchRange(int[] A, int target) {
    	if(A == null || A.length == 0) return new int[]{-1, -1};
    	int U, L;
    	int left, right;
    	U = A.length;
    	L = -1;
    	while(L + 1 < U){
    		int mid = L + (U - L) / 2;
    		if(A[mid] >= target){
    			U = mid;
    		}else{
    			L = mid;
    		}
    	}
    	if(U < A.length && A[U] == target) left = U;
    	else left = -1;
    	
    	U = A.length;
    	L = -1;
    	while(L + 1 < U){
    		int mid = L + (U - L) / 2;
    		if(A[mid] <= target){
    			L = mid;
    		}else{
    			U = mid;
    		}
    	}
    	if(L >= 0 && A[L] == target) right = L;
    	else right = -1;
    	return new int[]{left, right};
    }
    
    public static void main(String[] args){
    	for(int x : new Solution().searchRange(new int[]{1, 2, 3, 3}, 4))
    		System.err.print(x + ", ");
    	System.err.println("");
    }
}
