package leetcode.combinations;

import java.util.ArrayList;

public class Solution {
	public static void dfs(ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> tmp, int n, int k, int cur, int depth){
		if(depth == k){
			ret.add(new ArrayList<Integer>(tmp));
		}else{
			for(int i = cur; i <= n; i++){
				tmp.add(i);
				dfs(ret, tmp, n, k, i + 1, depth + 1);
				tmp.remove(depth);
			}
		}
	}
	
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    	dfs(ret, new ArrayList<Integer>(), n, k, 1, 0);
    	return ret;
    }
    
    public static void main(String[] args){
    	ArrayList<ArrayList<Integer>> ans = new Solution().combine(0, 1);
    	for(ArrayList<Integer> al : ans){
    		for(int i : al){
    			System.err.print(i + ", ");
    		}
    		System.err.println("");
    	}
    }
}
