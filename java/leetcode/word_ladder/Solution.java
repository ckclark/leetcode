package leetcode.word_ladder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
	private boolean isOneStep(char[] a, char[] b, int strLen){
		boolean diff = false;
		for(int i = 0; i < strLen; i++){
			if(a[i] != b[i]){
				if(diff)
					return false;
				diff = true;
			}
		}
		return true;
	}
	
	public int ladderLength(String start, String end, HashSet<String> dict) {
		int strLen = start.length();
        if(start.equals(end)) return 0;
        if(isOneStep(start.toCharArray(), end.toCharArray(), strLen)) return 2;
        Map<String, Integer> startDepth = new HashMap<String, Integer>();
        Map<String, Integer> endDepth = new HashMap<String, Integer>();
        Queue<String> startQueue = new LinkedList<String>();
        Queue<String> endQueue = new LinkedList<String>();
        for(int i = 0; i < strLen; i++){
        	StringBuilder sb = new StringBuilder(start);
        	for(char c = 'a'; c <= 'z'; c++){
        		if(start.charAt(i) != c){
        			sb.setCharAt(i, c);
        			String oneStep = sb.toString();
        			if(dict.contains(oneStep)){
        				startDepth.put(oneStep, 1);
        				startQueue.offer(oneStep);
        			}
        		}
        	}
        }
        for(int i = 0; i < strLen; i++){
        	StringBuilder sb = new StringBuilder(end);
        	for(char c = 'a'; c <= 'z'; c++){
        		if(end.charAt(i) != c){
        			sb.setCharAt(i, c);
        			String oneStep = sb.toString();
        			if(dict.contains(oneStep)){
        				if(startDepth.containsKey(oneStep))
        					return 3;
        				endDepth.put(oneStep, 1);
        				endQueue.offer(oneStep);
        			}
        		}
        	}
        }
        for(int depth = 1; !startQueue.isEmpty() || !endQueue.isEmpty(); depth++){
        	while(!startQueue.isEmpty()){
        		String cur = startQueue.peek();
        		if(startDepth.get(cur) > depth) break;
        		startQueue.remove();
        		for(int i = 0; i < strLen; i++){
        			StringBuilder sb = new StringBuilder(cur);
                	for(char c = 'a'; c <= 'z'; c++){
                		if(cur.charAt(i) != c){
                			sb.setCharAt(i, c);
                			String oneStep = sb.toString();
                			if(dict.contains(oneStep) && !startDepth.containsKey(oneStep)){
                				Integer inEnd = endDepth.get(oneStep);
            					if(inEnd != null){
            						return inEnd + depth + 2;
            					}
                				startDepth.put(oneStep, 1 + depth);
                				startQueue.offer(oneStep);
                			}
                		}
                	}
                }
        	}
        	while(!endQueue.isEmpty()){
        		String cur = endQueue.peek();
        		if(endDepth.get(cur) > depth) break;
        		endQueue.remove();
        		for(int i = 0; i < strLen; i++){
        			StringBuilder sb = new StringBuilder(cur);
                	for(char c = 'a'; c <= 'z'; c++){
                		if(cur.charAt(i) != c){
                			sb.setCharAt(i, c);
                			String oneStep = sb.toString();
                			if(dict.contains(oneStep) && !endDepth.containsKey(oneStep)){
                				Integer inStart = startDepth.get(oneStep);
            					if(inStart != null){
            						return inStart + depth + 2;
            					}
                				endDepth.put(oneStep, 1 + depth);
                				endQueue.offer(oneStep);
                			}
                		}
                	}
                }
        	}
        }
        return 0;
    }
	
	public static void main(String[] args){
		System.err.println(new Solution().ladderLength("hot", "dog", new HashSet<String>(Arrays.asList(new String[]{"hot", "dog", "dot"}))));
	}
}
