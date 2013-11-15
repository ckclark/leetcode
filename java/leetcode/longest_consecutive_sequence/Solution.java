package leetcode.longest_consecutive_sequence;

import java.util.HashMap;

public class Solution {
	public static class Interval {
		public int start;
		public int end;
		public Interval() { start = 0; end = 0; }
		public Interval(int s, int e) { start = s; end = e; }
	}
	
	public int longestConsecutive(int[] num) {
    	HashMap<Integer, Interval> leftMap = new HashMap<Integer, Interval>();
    	HashMap<Integer, Interval> rightMap = new HashMap<Integer, Interval>();
    	for(int x : num){
    		Interval asLeft = leftMap.get(x);
    		Interval asRight = rightMap.get(x);
    		if(asLeft != null || asRight != null){
    			continue;
    		}
    		Interval leftIvl = rightMap.get(x - 1);
    		Interval rightIvl = leftMap.get(x + 1);
    		if(leftIvl == null && rightIvl == null){
    			Interval ivl = new Interval(x, x);
    			leftMap.put(x, ivl);
    			rightMap.put(x, ivl);
    		}else if(leftIvl != null && rightIvl == null){
    			leftIvl.end = x;
    			rightMap.remove(x - 1);
    			rightMap.put(x, leftIvl);
    		}else if(leftIvl == null && rightIvl != null){
    			rightIvl.start = x;
    			leftMap.remove(x + 1);
    			leftMap.put(x, rightIvl);
    		}else{
    			Interval ivl = leftIvl;
    			leftMap.remove(x + 1);
    			rightMap.remove(x - 1);
    			ivl.end = rightIvl.end;
    			leftMap.put(ivl.start, ivl);
    			rightMap.put(ivl.end, ivl);
    		}
    	}
    	int maxlength = 0;
    	for(Interval ivl : leftMap.values()){
    		int length = ivl.end - ivl.start + 1;
    		if(length > maxlength){
    			maxlength = length;
    		}
    	}
    	return maxlength;
    }
	
	public static void main(String[] args){
		System.err.println(new Solution().longestConsecutive(new int[]{2147483646,-2147483647,0,2,2147483644,-2147483645,2147483645}));
	}
}
