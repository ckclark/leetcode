package leetcode.permutations_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Solution {
	public void dfs(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> cur, Set<Integer> num, int depth, int n, HashMap<Integer, Integer> basket){
		if(depth == n){
			ans.add(new ArrayList<Integer>(cur));
		}else{
			for(int key : num){
				int cnt = basket.get(key);
				if(cnt > 0){
					cur.add(key);
					basket.put(key, cnt - 1);
					dfs(ans, cur, num, depth + 1, n, basket);
					basket.put(key, cnt);
					cur.remove(depth);
				}
			}
		}
	}
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return ans;
        HashMap<Integer, Integer> basket = new HashMap<Integer, Integer>();
        for(int x : num){
        	if(basket.containsKey(x)){
        		int cnt = basket.get(x);
        		basket.put(x, cnt + 1);
        	}else{
        		basket.put(x, 1);
        	}
        }
        dfs(ans, new ArrayList<Integer>(), basket.keySet(), 0, num.length, basket);
        return ans;
    }
    
    public static void main(String[] args){
    	for(ArrayList<Integer> ary : new Solution().permuteUnique(new int[]{2,2,4,5})){
    		for(int x : ary){
    			System.err.print(x + ", ");
    		}
    		System.err.println("");;
    	}
    }
}
