package leetcode.merge_intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import common.Interval;

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    	ArrayList<Interval> ans = new ArrayList<Interval>();
    	for(int i = intervals.size() - 1; i >= 0; i--){
    		Interval iv = intervals.get(i);
    		if(iv.start > iv.end){
    			int tmp = iv.start;
    			iv.start = iv.end;
    			iv.end = tmp;
    		}
    	}
    	int size = intervals.size();
    	if(intervals.size() == 0) return ans;
    	Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval iv1, Interval iv2) {
				if(iv1.start < iv2.start) return -1;
				if(iv1.start > iv2.start) return 1;
				return 0;
			}
    	});
    	Interval cur = intervals.get(0);
    	int index = 1;
    	while(true){
    		while(index < size && intervals.get(index).start <= cur.end){
    			cur.end = Math.max(cur.end, intervals.get(index).end);
    			index++;
    		}
    		ans.add(cur);
    		if(index < size)
    			cur = intervals.get(index); 
    		else
    			break;
    	}
    	return ans;
    }
    
    public static void main(String[] args){
    	ArrayList<Interval> input = new ArrayList<Interval>();
    	//[1,3],[2,6],[8,10],[15,18]
    	input.add(new Interval(0, 4));
    	input.add(new Interval(0, 0));
    	for(Interval iv : new Solution().merge(input)){
    		System.err.println(iv.start + "," + iv.end);
    	}
    }
}
