package leetcode.combination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	public static class MutableInt{
		private int val;
		public MutableInt(){
			val = 0;
		}
		public void increment(){
			val++;
		}
		public int get(){
			return val;
		}
	}

	public void dfs(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> cur, Map<Integer, MutableInt> counter, Integer[] intSet, int depth, int target, int sum){
		if(sum == target){
			ans.add(new ArrayList<Integer>(cur));
		}else if(depth < intSet.length){
			int cnt;
			dfs(ans, cur, counter, intSet, depth + 1, target, sum);
			int maxCnt = counter.get(intSet[depth]).get();
			for(cnt = 1; sum + intSet[depth] * cnt <= target && cnt <= maxCnt; cnt++){
				cur.add(intSet[depth]);
				dfs(ans, cur, counter, intSet, depth + 1, target, sum + intSet[depth] * cnt);
			}
			cur.subList(cur.size() - cnt + 1, cur.size()).clear();
		}
	}
	
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    	if(num == null || num.length == 0) return ans;
    	Map<Integer, MutableInt> counter = new HashMap<Integer, MutableInt>();
    	for(int x : num){
    		MutableInt mi = counter.get(x);
    		if(mi == null){
    			mi = new MutableInt();
    			counter.put(x, mi);
    		}
    		mi.increment();
    	}
    	Integer[] intSet = counter.keySet().toArray(new Integer[0]);
    	Arrays.sort(intSet);
    	dfs(ans, new ArrayList<Integer>(), counter, intSet, 0, target, 0);
    	return ans;
    }
    
    public static void main(String[] args){
    	for(ArrayList<Integer> row : new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8)){
    		for(int x : row){
    			System.err.print(x + ", ");
    		}
    		System.err.println("");
    	}
    }
}
