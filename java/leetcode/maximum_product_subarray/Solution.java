package leetcode.maximum_product_subarray;

public class Solution {
    public int maxProduct(int[] A) {
    	int max = A[0];
    	int start = 0, end = 0;
    	for(int i = 0; i < A.length; i++){
    		if(A[i] > max) max = A[i];
    		if(A[i] == 0){
    			end = i - 1;
    			if(start <= end){
    				int product_forward = 1;
    				int product_backward = 1;
    				for(int j = 0; j <= end - start; j++){
    					product_forward *= A[start + j];
    					product_backward *= A[end - j];
    					if(product_forward > max){
    						max = product_forward;
    					}
    					if(product_backward > max){
    						max = product_backward;
    					}
    				}
    			}
    			start = i + 1;
    		}
    	}
    	if(start < A.length){
    		end = A.length - 1;
			if(start <= end){
				int product_forward = 1;
				int product_backward = 1;
				for(int j = 0; j <= end - start; j++){
					product_forward *= A[start + j];
					product_backward *= A[end - j];
					if(product_forward > max){
						max = product_forward;
					}
					if(product_backward > max){
						max = product_backward;
					}
				}
			}
    	}
    	return max;
    }
    
    public static void main(String[] args){
    	int ans = new Solution().maxProduct(new int[]{-2, 0, -1});
    	System.err.println("ans = " + ans);
    }
}
