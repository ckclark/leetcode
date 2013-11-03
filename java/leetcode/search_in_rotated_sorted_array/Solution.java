package leetcode.search_in_rotated_sorted_array;

import java.util.Random;

public class Solution {
	public int search(int[] A, int target) {
		int size = A.length;
		if(size == 0) return -1;
		if(size == 1){
			if(target == A[0]){
				return 0;
			}else{
				return -1;
			}
		}
		if(target <= A[size - 1]){
			if(A[size - 1] == target) return size - 1;
			if(A[0] == target) return 0;
			int U = size - 1;
			int L = 0;
			while(L < U - 1){
				int mid = (U + L) / 2;
				
				if(A[mid] == target) return mid;
				if(A[mid] > A[size - 1] || A[mid] < target){
					L = mid;
				}else{
					U = mid;
				}
			}
			return -1;
		}else if(target >= A[0]){
			if(A[0] == target) return 0;
			if(A[size - 1] == target) return size - 1;
			int U = size - 1;
			int L = 0;
			while(L < U - 1){
				int mid = (U + L) / 2;
				if(A[mid] == target) return mid;
				if(A[mid] < A[0] || A[mid] > target){
					U = mid;
				}else{
					L = mid;
				}
			}
			return -1;
		}else{
			return -1;
		}
    }
	
	public static void main(String[] args){
		final int N = 3;
		int[] ary = new int[N];
		int r = 0;
		System.err.println("sol.seaerch(new int[]{1, 3}, 1) = " + (new Solution().search(new int[]{1, 3}, 1)));
		while(r == 0){
			r = new Random().nextInt(N);
		}
		System.err.println("r = " + r);
		for(int i = 0; i < N; i++){
			ary[(i + r) % N] = i * 2;
		}
		Solution sol = new Solution();
		System.err.println("sol.search(ary, 100) = " + (sol.search(ary, 100)));
		for(int i = 0; i < 2 * N; i++){
			int ret = sol.search(ary, i);
			if(i % 2 == 0){
				if(ret == -1 || ary[ret] != i) System.err.println("WA: should have found");
			}else{
				if(ret != -1) System.err.println("Should be -1 when i = " + i);
			}
		}
	}
}
