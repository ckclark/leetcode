package leetcode.pascals_triangle_ii;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> ary = new ArrayList<Integer>();
        long C = 1;
        ary.add((int)C);
        for(int i = 1; i <= rowIndex; i++){
        	C *= rowIndex + 1 - i;
        	C /= i;
        	ary.add((int)C);
        }
        return ary;
    }
    
    public static void main(String[] args){
    	for(int x : new Solution().getRow(20)){
    		System.err.print(x + ", ");
    	}
    	System.err.println("");
    }
}
