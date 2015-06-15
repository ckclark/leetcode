package leetcode.combination_sum_iii;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public void dfs(int curN, int rest, int depth, int k, List<Integer> cur, List<List<Integer>> ret){
        if(depth == k && rest == 0){
            ret.add(new ArrayList<Integer>(cur));
        }else{
            for(int i = curN + 1; i <= 9; i++){
                if(rest - i >= 0){
                    cur.add(i);
                    dfs(i, rest - i, depth + 1, k, cur, ret);
                    cur.remove(depth);
                }
            }
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        dfs(0, n, 0, k, new ArrayList<Integer>(), ret);
        return ret;
    }
    
    public static void main(String[] args){
        for(List<Integer> ans : new Solution().combinationSum3(3, 9)){
            for(int x : ans){
                System.err.print(x + " ");
            }
            System.err.println("");
        }
    }
}
