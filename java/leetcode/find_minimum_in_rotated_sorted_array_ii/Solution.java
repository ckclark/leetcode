package leetcode.find_minimum_in_rotated_sorted_array_ii;

public class Solution {
    public int findMin(int[] num) {
    	int min = num[0];
    	for(int n : num){
    		if(n < min){
    			min = n;
    		}
    	}
    	return min;
    }
}
