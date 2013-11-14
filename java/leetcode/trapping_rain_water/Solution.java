package leetcode.trapping_rain_water;

public class Solution {
    public int trap(int[] A) {
    	if(A == null || A.length == 0) return 0;
    	int len = A.length;
    	int maxi = len - 1;
    	int max = A[len - 1];
    	for(int i = len - 1; i >= 0; i--){
    		if(A[i] > max){
    			maxi = i;
    			max = A[i];
    		}
    	}
        int cur = 0;
        int water = 0;
        for(int i = 0; i < maxi; i++){
        	if(A[i] > cur){
        		cur = A[i];
        	}else{
        		water += cur - A[i];
        	}
        }
        cur = 0;
        for(int i = len - 1; i > maxi; i--){
        	if(A[i] > cur){
        		cur = A[i];
        	}else{
        		water += cur - A[i];
        	}
        }
        return water;
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().trap(new int[]{0, 1, 0, 2, 3, 0, 1, 3, 2, 1, 2, 1}));
    }
}
