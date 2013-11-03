package leetcode.merge_sorted_array;

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
    	int tail = m + n - 1;
    	n--;
    	m--;
    	while(tail >= 0){
    		if(n < 0){
    			return;
    		}else if(m < 0){
    			A[tail--] = B[n--];
    		}else if(A[m] > B[n]){
    			A[tail--] = A[m--];
    		}else{
    			A[tail--] = B[n--];
    		}
    	}
    }
}
