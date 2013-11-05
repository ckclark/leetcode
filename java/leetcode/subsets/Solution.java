package leetcode.subsets;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public void dfs(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> cur, int[] S, int depth, int n){
		if(depth == n){
			ans.add(new ArrayList<Integer>(cur));
		}else{
			cur.add(S[depth]);
			dfs(ans, cur, S, depth + 1, n);
			cur.remove(cur.size() - 1);
			dfs(ans, cur, S, depth + 1, n);
		}
	}
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if(S == null) return ans;
		Arrays.sort(S);
		dfs(ans, new ArrayList<Integer>(), S, 0, S.length);
		return ans;
    }
    
    public static void main(String[] args){
    	for(ArrayList<Integer> ary : new Solution().subsets(new int[]{})){
    		for(int x : ary){
    			System.err.print(x + ", ");
    		}
    		System.err.println("");;
    	}
    }
}
