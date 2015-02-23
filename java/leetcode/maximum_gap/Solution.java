package leetcode.maximum_gap;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maximumGap(int[] num) {
        if(num == null || num.length < 2) return 0;
        int length = num.length;
        List<List<Integer>> buckets = new ArrayList<List<Integer>>(length - 1);
        for(int i = 0; i < length - 1; i++){
        	buckets.add(new ArrayList<Integer>());
        }
        int min = num[0], max = num[0];
        for(int x : num){
        	if(x < min){
        		min = x;
        	}
        	if(x > max){
        		max = x;
        	}
        }
        int range = max - min;
        for(int x : num){
        	long diff = x - min;
        	if(x < max){
        		int idx = (int)(diff * (length - 1) / range);
        		buckets.get(idx).add(x);
        	}
        }
        List<Integer> bmins = new ArrayList<Integer>();
        List<Integer> bmaxs = new ArrayList<Integer>();
        for(List<Integer> bucket : buckets){
        	if(bucket.size() > 0){
        		int bmin = bucket.get(0);
        		int bmax = bucket.get(0);
        		for(int b : bucket){
        			if(b < bmin)
        				bmin = b;
        			if(b > bmax)
        				bmax = b;
        		}
        		bmins.add(bmin);
        		bmaxs.add(bmax);
        	}
        }
        int maxgap = 0;
        int currmin = min;
        int bsize = bmins.size();
        for(int i = 0; i < bsize; i++){
        	maxgap = Math.max(maxgap, bmins.get(i) - currmin);
        	currmin = bmaxs.get(i);
        }
        maxgap = Math.max(maxgap, max - currmin);
        return maxgap;
    }
}
