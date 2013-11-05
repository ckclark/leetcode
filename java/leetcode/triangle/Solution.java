package leetcode.triangle;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int size = triangle.size();
        for(int i = size - 1; i > 0; i--){
        	for(int j = 0; j < i; j++){
        		ArrayList<Integer> row_i = triangle.get(i);
        		ArrayList<Integer> row_i_1 = triangle.get(i - 1);
        		int a = row_i.get(j);
        		int b = row_i.get(j + 1);
        		int v = row_i_1.get(j);
        		row_i_1.set(j, v + Math.min(a, b));
        	}
        }
        return triangle.get(0).get(0);
    }
    public static void main(String[] args){
    	ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
    	input.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{2})));
    	input.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{3, 4})));
    	input.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{6, 5, 7})));
    	input.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{4, 1, 8, 3})));
    	System.err.println(new Solution().minimumTotal(input) + "");
    }
}
