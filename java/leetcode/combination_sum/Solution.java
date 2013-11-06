package leetcode.combination_sum;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	public void dfs(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> cur, int[] candidates, int depth, int target, int sum){
		if(sum == target){
			ans.add(new ArrayList<Integer>(cur));
		}else if(depth < candidates.length){
			int cnt = 0;
			while(sum + candidates[depth] * cnt <= target){
				dfs(ans, cur, candidates, depth + 1, target, sum + candidates[depth] * cnt);
				cnt++;
				cur.add(candidates[depth]);
			}
			cur.subList(cur.size() - cnt, cur.size()).clear();
		}
	}
	
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    	if(candidates == null || candidates.length == 0) return ans;
    	Arrays.sort(candidates);
    	dfs(ans, new ArrayList<Integer>(), candidates, 0, target, 0);
    	return ans;
    }
    
    public static void main(String[] args){
    	for(ArrayList<Integer> row : new Solution().combinationSum(new int[]{2, 3, 7, 6}, 7)){
    		for(int x : row){
    			System.err.print(x + ", ");
    		}
    		System.err.println("");
    	}
    }
}
