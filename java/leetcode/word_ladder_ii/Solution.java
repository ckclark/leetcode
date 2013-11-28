package leetcode.word_ladder_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
	Map<String, Set<String>> startPrev;
	Map<String, Set<String>> endPrev;

	Map<String, Integer> startDepth;
    Map<String, Integer> endDepth;
    Queue<String> startQueue;
    Queue<String> endQueue;
    String start, end;
    ArrayList<ArrayList<String>> ans;

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
	
	
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
    	this.start = start;
    	this.end = end;
    	ans = new ArrayList<ArrayList<String>>();
    	int strLen = start.length();
    	if(isOneStep(start.toCharArray(), end.toCharArray(), strLen)){
    		ans.add(new ArrayList<String>(Arrays.asList(new String[]{start, end})));
    		return ans;
    	}
    	startPrev = new HashMap<String, Set<String>>();
    	endPrev = new HashMap<String, Set<String>>();

    	startDepth = new HashMap<String, Integer>();
        endDepth = new HashMap<String, Integer>();
        startQueue = new LinkedList<String>();
        endQueue = new LinkedList<String>();
        for(int i = 0; i < strLen; i++){
        	StringBuilder sb = new StringBuilder(start);
        	for(char c = 'a'; c <= 'z'; c++){
        		if(start.charAt(i) != c){
        			sb.setCharAt(i, c);
        			String oneStep = sb.toString();
        			if(dict.contains(oneStep)){
        				startDepth.put(oneStep, 1);
        				startQueue.offer(oneStep);
        				startPrev.put(oneStep, new HashSet<String>(Arrays.asList(new String[]{start})));
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
        				if(startDepth.containsKey(oneStep)){
        					ans.add(new ArrayList<String>(Arrays.asList(new String[]{start, oneStep, end})));
        				}
        				endDepth.put(oneStep, 1);
        				endQueue.offer(oneStep);
        				endPrev.put(oneStep, new HashSet<String>(Arrays.asList(new String[]{end})));
        			}
        		}
        	}
        }
        if(ans.size() > 0) return ans;
        boolean found = false;
        for(int depth = 1; (!startQueue.isEmpty() || !endQueue.isEmpty()) && !found; depth++){
        	Set<String> middle = new HashSet<String>();
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
                			if(dict.contains(oneStep)){
                				Integer depthValue = startDepth.get(oneStep);
                				if(depthValue == null){
                					startDepth.put(oneStep, 1 + depth);
                					startQueue.offer(oneStep);
                					startPrev.put(oneStep, new HashSet<String>(Arrays.asList(new String[]{cur})));
                					Integer inEnd = endDepth.get(oneStep);
                					if(inEnd != null){
                						found = true;
                						middle.add(oneStep);
                					}
                				}else if(depthValue.intValue() == depth + 1){
                					startPrev.get(oneStep).add(cur);
                				}
                			}
                		}
                	}
                }
        	}
        	if(!found){
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
        						if(dict.contains(oneStep)){
        							Integer depthValue = endDepth.get(oneStep);
        							if(depthValue == null){
        								endDepth.put(oneStep, 1 + depth);
        								endQueue.offer(oneStep);
        								endPrev.put(oneStep, new HashSet<String>(Arrays.asList(new String[]{cur})));
        								Integer inStart = startDepth.get(oneStep);
        								if(inStart != null){
        									found = true;
        									middle.add(oneStep);
        								}
        							}else if(depthValue.intValue() == depth + 1){
        								endPrev.get(oneStep).add(cur);
        							}
        						}
        					}
        				}
        			}
        		}
        	}
        	if(found){
        		for(String m : middle){
        			addToAns(m);
        		}
        	}
        }
        return ans;
    }
    
    private void dfs(ArrayList<ArrayList<String>> halfAns, String middle, Map<String, Set<String>> prev, String stop, ArrayList<String> cur, boolean isReverse){
    	if(middle.equals(stop)){
    		ArrayList<String> tmp = new ArrayList<String>(cur);
    		if(isReverse){
    			Collections.reverse(tmp);
    		}
    		halfAns.add(tmp);
    	}else{
    		for(String next : prev.get(middle)){
    			cur.add(next);
    			dfs(halfAns, next, prev, stop, cur, isReverse);
    			cur.remove(cur.size() - 1);
    		}
    	}
    }
    
    private void addToAns(String middle) {
    	ArrayList<ArrayList<String>> fromStart = new ArrayList<ArrayList<String>>();
    	ArrayList<ArrayList<String>> toEnd = new ArrayList<ArrayList<String>>();
    	dfs(fromStart, middle, startPrev, start, new ArrayList<String>(), true);
    	dfs(toEnd, middle, endPrev, end, new ArrayList<String>(), false);
    	for(ArrayList<String> fs : fromStart){
    		int fsSize = fs.size();
    		ArrayList<String> tmp = new ArrayList<String>(fs);
    		for(ArrayList<String> te : toEnd){
    			int teSize = te.size();
    			tmp.add(middle);
    			tmp.addAll(te);
    			ans.add(new ArrayList<String>(tmp));
    			tmp.subList(fsSize, fsSize + teSize + 1).clear();
    		}
    	}
	}

	public static void main(String[] args){
    	String start = "aaa";
    	String end = "ccc";
    	HashSet<String> dict = new HashSet<String>(Arrays.asList(new String[]{"aba","aab","baa","abb","bba", "bab", "bbb", "bcb", "bbc", "cbb", "ccb", "bcc", "cbc"}));

//    	String start = "hit";
//    	String end = "cog";
//    	HashSet<String> dict = new HashSet<String>(Arrays.asList(new String[]{"hot","dot","dog","lot","log"}));

    	for(ArrayList<String> row : new Solution().findLadders(start, end, dict)){
    		String prefix = "";
    		for(String s : row){
    			System.err.print(prefix + s);
    			prefix = "->";
    		}
    		System.err.println("");
    	}
    }
}
