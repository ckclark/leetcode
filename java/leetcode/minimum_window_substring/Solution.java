package leetcode.minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static class MutableInt{
		private int val;
		public MutableInt(){
			val = 0;
		}
		public void increment(){
			val++;
		}
		public void decrement(){
			val--;
		}
		public int get(){
			return val;
		}
	}
	
    public String minWindow(String S, String T) {
    	if(S == null || S.length() == 0) return "";
    	if(T == null || T.length() == 0) return "";
    	Map<Character, MutableInt> outside = new HashMap<Character, MutableInt>();
    	Map<Character, MutableInt> inside = new HashMap<Character, MutableInt>();
    	char[] chars = S.toCharArray();
    	char[] chart = T.toCharArray();
    	int lens = chars.length;
    	int lent = chart.length;
    	for(char c : chart){
    		MutableInt mi = outside.get(c);
    		if(mi == null){
    			mi = new MutableInt();
    			outside.put(c, mi);
    			inside.put(c, new MutableInt());
    		}
    		mi.increment();
    	}
    	int remaining = lent;
    	int left = 0, right = 0;
    	int min = lens + 1;
    	String minString = ""; 
    	while(right < lens){
    		while(right < lens && remaining > 0){
    			char c = chars[right];
    			MutableInt outsideCount = outside.get(c);
    			MutableInt insideCount = inside.get(c);
    			if(outsideCount != null){
	    			if(outsideCount.get() > 0){
	    				remaining--;
	    			}
	    			insideCount.increment();
	    			outsideCount.decrement();
    			}
    			right++;
    		}
    		while(remaining == 0){
    			char c = chars[left];
    			MutableInt outsideCount = outside.get(c);
    			MutableInt insideCount = inside.get(c);
    			if(outsideCount != null){
    				if(outsideCount.get() <= 0){
    					if(right - left < min){
    						min = right - left;
    						minString = new String(chars, left, min);
    					}
    				}
    				outsideCount.increment();
    				insideCount.decrement();
    				if(outsideCount.get() > 0){
    					remaining++;
    					left++;
    					break;
    				}
    			}
    			left++;
    		}
    	}
    	return minString;
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().minWindow("EBADOBCCCCE", "AO"));
    }
}
