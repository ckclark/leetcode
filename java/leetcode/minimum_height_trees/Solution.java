package leetcode.minimum_height_trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Object[] neighbors = new Object[n];
        int[] degree = new int[n];
        for(int i = 0; i < n; i++){
            neighbors[i] = new ArrayList<Integer>();
        }
        for(int[] edge : edges){
            int fr = edge[0], to = edge[1];
            List<Integer> l;
            l = (List<Integer>)neighbors[fr];
            l.add(to);
            degree[fr]++;

            l = (List<Integer>)neighbors[to];
            l.add(fr);
            degree[to]++;
        }
        List<Integer> queue = new ArrayList<Integer>();
        Set<Integer> visit = new HashSet<Integer>();
        for(int i = 0; i < n; i++){
            if(degree[i] <= 1){
                queue.add(i);
            }
        }
        List<Integer> nxtQueue = new ArrayList<Integer>();
        while(!queue.isEmpty() && visit.size() < n - 2){
            nxtQueue = new ArrayList<Integer>();
            for(int v : queue){
                visit.add(v);
                for(int adj : (List<Integer>)neighbors[v]){
                    if(!visit.contains(adj)){
                        degree[adj]--;
                        if(degree[adj] == 1){
                            nxtQueue.add(adj);
                        }
                    }
                }
            }
            queue = nxtQueue;
        }
        return queue;
    }
}