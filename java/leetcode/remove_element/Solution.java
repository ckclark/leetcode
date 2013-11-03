package leetcode.remove_element;

public class Solution {
    public int removeElement(int[] A, int elem) {
    	if(A == null) return 0;
    	int tail = A.length - 1;
    	for(int i = 0; i < A.length; i++){
    		if(A[i] == elem){
    			while(tail >= 0 && A[tail] == elem){
    				tail--;
    			}
    			if(tail > i){
    				A[i] = A[tail];
    				tail--;
    			}
    			else break;
    		}
    	}
    	return tail + 1;
    }
    
    public static void main(String[] args){
    	int[] ary = new int[]{3, 2, 2, 2, 5, 8, 3, 3};
    	int len = new Solution().removeElement(ary, 3);
    	System.err.println("len = " + len);
    	for(int i = 0; i < len; i++){
    		System.err.print(ary[i] + ", ");
    	}
    	System.err.println("");
    }
}
