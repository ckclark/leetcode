package leetcode.permutations;

import java.util.ArrayList;

public class Solution {
	public void dfs(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> cur, int[] num, int depth, boolean visit[]){
		if(depth == num.length){
			ans.add(new ArrayList<Integer>(cur));
		}else{
			for(int i = 0; i < num.length; i++){
				if(!visit[i]){
					visit[i] = true;
					cur.add(num[i]);
					dfs(ans, cur, num, depth + 1, visit);
					visit[i] = false;
					cur.remove(depth);
				}
			}
		}
	}
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
    	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return ans;
        boolean[] visit = new boolean[num.length];
        dfs(ans, new ArrayList<Integer>(), num, 0, visit);
        return ans;
    }
    
    public static void main(String[] args){
    	for(ArrayList<Integer> ary : new Solution().permute(new int[]{2,3,4,5,6})){
    		for(int x : ary){
    			System.err.print(x + ", ");
    		}
    		System.err.println("");;
    	}
    }
}
