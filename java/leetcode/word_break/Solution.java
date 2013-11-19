package leetcode.word_break;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public boolean wordBreak(String s, Set<String> dict, int minlength) {
		if(dict.contains(s)) return true;
		char[] chars = s.toCharArray();
		int len = chars.length;
		for(int i = minlength; i <= len - minlength; i++){
			if(dict.contains(s.substring(i)) && wordBreak(s.substring(0, i), dict, minlength)){
				return true;
			}
		}
		return false;
	}
    public boolean wordBreak(String s, Set<String> dict) {
    	if(dict.size() == 0) return s.length() == 0;
    	int minlength = -1;
    	for(String word : dict){
    		if(minlength == -1 || word.length() < minlength){
    			minlength = word.length();
    		}
    	}
    	return wordBreak(s, dict, minlength);
    }
    
    public static void main(String[] args){
    	Set<String> input = new HashSet<String>();
    	input.add("leet");
    	input.add("code");
    	input.add("b");
    	System.err.println(new Solution().wordBreak("leetcodea", input));
    }
}