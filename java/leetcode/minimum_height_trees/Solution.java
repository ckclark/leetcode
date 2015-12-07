package leetcode.minimum_height_trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Object[] neighbors = new Object[n];
        for(int i = 0; i < n; i++){
            neighbors[i] = new ArrayList<Integer>();
        }
        for(int[] edge : edges){
            int fr = edge[0], to = edge[1];
            List<Integer> l;
            l = (List<Integer>)neighbors[fr];
            l.add(to);

            l = (List<Integer>)neighbors[to];
            l.add(fr);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(0);
        Set<Integer> visit = new HashSet<Integer>();
        visit.add(0);
        int farthest = 0;
        while(!q.isEmpty()){
            int cur = q.remove();
            farthest = cur;
            for(int neighbor : (List<Integer>)neighbors[cur]){
                if(!visit.contains(neighbor)){
                    q.offer(neighbor);
                    visit.add(neighbor);
                }
            }
        }
        int mht_height = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(farthest);
        visit.clear();
        visit.add(farthest);
        List<Integer> ans = new ArrayList<Integer>();
        while(!stack.isEmpty()){
            int cur = stack.peek();
            int l = stack.size();
            if(l > mht_height){
                ans.clear();
                if(l % 2 == 0){
                    ans.add(stack.get(l / 2));
                    ans.add(stack.get((l - 1) / 2));
                }else{
                    ans.add(stack.get(l / 2));
                }
                mht_height = l;
            }
            boolean flag = true;
            for(int neighbor : (List<Integer>)neighbors[cur]){
                if(!visit.contains(neighbor)){
                    flag = false;
                    stack.push(neighbor);
                    visit.add(neighbor);
                    break;
                }
            }
            if(flag){
                stack.pop();
            }
        }
        return ans;
    }
}