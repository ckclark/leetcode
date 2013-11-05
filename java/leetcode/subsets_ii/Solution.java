package leetcode.subsets_ii;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public void dfs(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> cur, int[] num, int n, int depth){
		if(depth == n){
			ans.add(new ArrayList<Integer>(cur));
		}else{
			int v = num[depth];
			int cnt = 0;
			for(int x = depth; x < n && num[x] == v; x++){
				cnt++;
			}
			dfs(ans, cur, num, n, depth + cnt);
			for(int i = 0; i < cnt; i++){
				cur.add(v);
				dfs(ans, cur, num, n, depth + cnt);
			}
			cur.subList(cur.size() - cnt, cur.size()).clear();
		}
	}
	
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
    	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    	if(num == null || num.length == 0) return ans;
    	Arrays.sort(num);
    	dfs(ans, new ArrayList<Integer>(), num, num.length, 0);
    	return ans;
    }
    
    public static void main(String[] args){
    	for(ArrayList<Integer> ary : new Solution().subsetsWithDup(new int[]{1, 2, 2, 3})){
    		for(int x : ary){
    			System.err.print(x + ", ");
    		}
    		System.err.println("");
    	}
    }
}
