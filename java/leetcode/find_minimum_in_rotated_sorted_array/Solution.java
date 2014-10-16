package leetcode.find_minimum_in_rotated_sorted_array;

public class Solution {
    public int findMin(int[] num) {
    	int size = num.length;
    	if(num[0] <= num[size - 1]){ // Not rotated
    		return num[0];
    	}
    	int L = -1, U = size;
    	while(L + 1 < U){
    		int mid = L + (U - L) / 2;
    		if(num[mid] > num[size - 1]){
    			L = mid;
    		}else{
    			U = mid;
    		}
    	}
    	return num[U];
    }
}