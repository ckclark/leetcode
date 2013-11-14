package leetcode.remove_duplicates_from_sorted_array_ii;

import java.util.Random;

public class Solution {
    public int removeDuplicates(int[] A) {
    	if(A == null || A.length == 0) return 0;
    	int idx = 0, search = 1;
    	while(true){
    		boolean duplicated = false;
    		while(search < A.length && A[search] == A[idx]){
    			if(A[search] == A[idx] && !duplicated){
    				duplicated = true;
    				A[++idx] = A[search];
    			}
    			search++;
    		}
    		if(search >= A.length) return idx + 1;
    		A[idx + 1] = A[search];
    		idx++;
    		search++;
    	}
    }
    
    public static void dump(int[] ary, int length){
    	for(int i = 0; i < length; i++){
			System.err.print(ary[i] + ", ");
		}
    	System.err.println("");
	}
    
	public static void main(String[] args){
		final int N = 10;
		Random r = new Random();
		int[] ary = new int[N];
		for(int i = 0; i < N; i++){
			int v = 0;
			if(i > 0) v = ary[i - 1]; 
			ary[i] = v + r.nextInt(2);
		}
		dump(ary, ary.length);
		int ret = new Solution().removeDuplicates(ary);
		dump(ary, ret);
	}
}
