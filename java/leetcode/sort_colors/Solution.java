package leetcode.sort_colors;

import java.util.Random;

public class Solution {
    public void sortColors(int[] A) {
    	if(A == null) return;
    	if(A.length == 0) return;
    	int head = -1, tail = A.length;
    	int x = 0;
    	while(x < tail){
    		while(head < Math.min(tail, A.length - 1) && A[head + 1] == 0) head++;
    		while(tail > Math.max(0, head) && A[tail - 1] == 2) tail--;
    		if(x < head + 1)
    			x = head + 1;
    		while(x < tail && A[x] == 1) x++;
    		
    		if(x < tail){
    			if(A[x] == 0){
    				int tmp = A[x];
    				A[x] = A[head + 1];
    				A[head + 1] = tmp;
    				while(A[head + 1] == 0) head++;
    			}else if(A[x] == 2){
    				int tmp = A[x];
    				A[x] = A[tail - 1];
    				A[tail - 1] = tmp;
    				while(A[tail - 1] == 2) tail--;
    			}
    		}
    	}
    }
    
    public static void dump(int[] input){
    	for(int x : input){
    		System.err.print(x + " ");
    	}
    	System.err.println("");
    }
    
    public static void main(String[] args){
    	final int N = 2;
    	int[] input = new int[N];
    	Random r = new Random();
    	for(int i = 0; i < N; i++){
    		input[i] = r.nextInt(3);
    	}
//    	input = new int[]{2, 1, 0, 2, 2, 2, 2, 0, 0, 2};
    	dump(input);
    	new Solution().sortColors(input);
    	dump(input);
    }
}
