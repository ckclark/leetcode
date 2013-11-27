package leetcode.interleaving_string;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static class PossibleState{
		int len1;
		int len2;
		public PossibleState(int len1, int len2){
			this.len1 = len1;
			this.len2 = len2;
		}
	}
    public boolean isInterleave(String s1, String s2, String s3) {
    	if(s1.length() + s2.length() != s3.length()) return false;
    	boolean[][] possible = new boolean[s1.length() + 1][s2.length() + 1];
    	Queue<PossibleState> queue = new LinkedList<PossibleState>();
    	possible[0][0] = true;
    	queue.offer(new PossibleState(0, 0));
    	while(!queue.isEmpty()){
    		PossibleState state = queue.remove();
    		int totalLen = state.len1 + state.len2;
    		if(totalLen == s3.length()) return true;
    		if(state.len1 < s1.length()){
    			if(!possible[state.len1 + 1][state.len2]){
    				if(s1.charAt(state.len1) == s3.charAt(totalLen)){
    					possible[state.len1 + 1][state.len2] = true;
    					queue.offer(new PossibleState(state.len1 + 1, state.len2));
    				}
    			}
    		}
    		if(state.len2 < s2.length()){
    			if(!possible[state.len1][state.len2 + 1]){
    				if(s2.charAt(state.len2) == s3.charAt(totalLen)){
    					possible[state.len1][state.len2 + 1] = true;
    					queue.offer(new PossibleState(state.len1, state.len2 + 1));
    				}
    			}
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().isInterleave("abccc", "deffg", "adeffgbccc"));
    }
}
