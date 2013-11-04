package leetcode.pascals_triangle;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < numRows; i++){
        	ArrayList<Integer> tmp = new ArrayList<Integer>();
        	for(int j = 0; j <= i; j++){
        		if(j == 0){
        			tmp.add(1);
        		}else if(j < i){
        			tmp.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
        		}else{
        			tmp.add(1);
        		}
        	}
        	ans.add(tmp);
        }
        return ans;
    }
    
    public static void main(String[] args){
    	ArrayList<ArrayList<Integer>> ans = new Solution().generate(0);
    	for(ArrayList<Integer> row : ans){
    		for(int x : row){
    			System.err.print(x + ", ");
    		}
    		System.err.println("");
    	}
    }
}
