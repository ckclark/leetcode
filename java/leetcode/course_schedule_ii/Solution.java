package leetcode.course_schedule_ii;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> mapForward = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Set<Integer>> mapBackward = new HashMap<Integer, Set<Integer>>();
        Set<Integer> allCourses = new HashSet<Integer>();
        int[] ret = new int[numCourses];
        int retIdx = 0;
        for(int i = 0; i < numCourses; i++){
            allCourses.add(i);
        }
        if(prerequisites == null) return new int[]{};
        for(int[] prerequisite : prerequisites){
            if(prerequisite[0] == prerequisite[1]) return new int[]{};
            Set<Integer> s;

            s = mapBackward.get(prerequisite[0]);
            if(s == null){
                s = new HashSet<Integer>();
                mapBackward.put(prerequisite[0], s);
            }
            s.add(prerequisite[1]);

            s = mapForward.get(prerequisite[1]);
            if(s == null){
                s = new HashSet<Integer>();
                mapForward.put(prerequisite[1], s);
            }
            s.add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int x : mapForward.keySet()){
            Set<Integer> s = mapBackward.get(x);
            if(s == null || s.size() == 0){
                queue.offer(x);
                allCourses.remove(x);
                ret[retIdx++] = x;
            }
        }
        while(!queue.isEmpty()){
            int x = queue.remove();
            Set<Integer> s = mapForward.get(x);
            if(s != null){
                for(int y : s){
                    Set<Integer> s2 = mapBackward.get(y);
                    s2.remove(x);
                    if(s2.isEmpty()){
                        queue.offer(y);
                        allCourses.remove(y);
                        ret[retIdx++] = y;
                    }
                }
            }
        }
        for(Set<Integer> s : mapBackward.values()){
            if(!s.isEmpty()) return new int[]{};
        }
        for(int x : allCourses){
            ret[retIdx++] = x;
        }
        return ret;
    }
}