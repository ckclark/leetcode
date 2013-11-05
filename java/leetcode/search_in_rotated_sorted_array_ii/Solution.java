package leetcode.search_in_rotated_sorted_array_ii;

import java.util.Random;

public class Solution {
	public boolean search(int[] A, int target) {
		int size = A.length;
		if(size == 0) return false;
		
		if(A[0] < A[size - 1]){
			int U = size;
			int L = -1;
			while(L < U - 1){
				int mid = (U + L) / 2;
				if(A[mid] == target) return true;
				if(A[mid] < target){
					L = mid;
				}else{
					U = mid;
				}
			}
			return false;
		}else if(A[0] > A[size - 1]){
			if(target <= A[size - 1]){
				int U = size;
				int L = -1;
				while(L < U - 1){
					int mid = (U + L) / 2;
					
					if(A[mid] == target) return true;
					if(A[mid] > A[size - 1] || A[mid] < target){
						L = mid;
					}else{
						U = mid;
					}
				}
				return false;
			}else if(target >= A[0]){
				int U = size;
				int L = -1;
				while(L < U - 1){
					int mid = (U + L) / 2;
					if(A[mid] == target) return true;
					if(A[mid] < A[0] || A[mid] > target){
						U = mid;
					}else{
						L = mid;
					}
				}
				return false;
			}else{
				return false;
			}
		}else{
			for(int x : A){
				if(x == target) return true;
			}
			return false;
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
	}
}
