package leetcode.insert_interval;

import java.util.ArrayList;

import common.Interval;

public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int size = intervals.size();
        if(size == 0){
        	intervals.add(newInterval);
        }else{
        	int L, U;
        	L = -1;
        	U = size;
        	while(L < U - 1){
        		int mid = L + (U - L) / 2;
        		if(intervals.get(mid).start > newInterval.start){
        			U = mid;
        		}else{
        			L = mid;
        		}
        	}
        	int mergeLeft = L;
        	L = -1;
        	U = size;
        	while(L < U - 1){
        		int mid = L + (U - L) / 2;
        		if(intervals.get(mid).end >= newInterval.end){
        			U = mid;
        		}else{
        			L = mid;
        		}
        	}
        	int mergeRight = U;
        	
        	int removeStart = mergeLeft;
        	if(removeStart == -1){
        		
        	}else if(intervals.get(mergeLeft).end < newInterval.start){
        		removeStart++;
        	}
        	int removeEnd = mergeRight;
        	if(removeEnd == size){								// [2, 5] [8, 11] [14, 17] 
        		
        	}else if(intervals.get(mergeRight).start > newInterval.end){
        		removeEnd--;
        	}
        	if(removeStart == removeEnd && (removeStart == -1 || removeStart == size)){
        		if(removeStart == -1){
        			intervals.add(0, newInterval);
        		}else if(removeStart == size){
        			intervals.add(size, newInterval);
        		}
        	}else{
        		if(removeStart < 0) removeStart = 0;
        		if(removeEnd >= size) removeEnd = size - 1;
        		newInterval.start = Math.min(newInterval.start, intervals.get(removeStart).start);
        		newInterval.end = Math.max(newInterval.end, intervals.get(removeEnd).end);
        		intervals.subList(removeStart, removeEnd + 1).clear();
        		intervals.add(removeStart, newInterval);
        	}
        }

        return intervals;
    }
    
    public static void dump(ArrayList<Interval> ans){
    	for(Interval iv : ans){
    		System.err.print("[" + iv.start + ", " + iv.end + "] ");
    	}
    }
    
    public static void main(String[] args){
    	int nInterval = 0;
    	int maxLeft = nInterval * 6;
    	for(int i = 0; i <= maxLeft; i++){
    		for(int j = i + 1; j <= maxLeft + 1; j++){
    			ArrayList<Interval> input = new ArrayList<Interval>();
    			for(int k = 0; k < nInterval; k++){
    				input.add(new Interval(k * 6 + 2, k * 6 + 5));
    			}
//    			dump(input);
    			System.err.println("new: [" + i + ", " + j + "]");
    			ArrayList<Interval> ans = new Solution().insert(input, new Interval(i, j));
    			dump(ans);
    			System.err.println("");
    		}
    	}
    }
}