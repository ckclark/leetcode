package leetcode.gray_code;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int prev = 0;
        ans.add(prev);
        for(int cnt = 0; cnt < (1 << n) - 1; cnt++){
        	int z = 0;
        	while(((1 << z) & cnt) != 0){
        		z++;
        	}
        	int next = prev ^ (1 << z);
        	ans.add(next);
        	prev = next;
        }
        return ans;
    }
    
    public static void main(String[] args){
    	ArrayList<Integer> ans = new Solution().grayCode(1);
    	for(int i : ans){
    		System.err.print(i + ", ");
    	}
    	System.err.println("");
    }
}
