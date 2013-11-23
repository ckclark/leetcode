package leetcode.word_break_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	public boolean wordBreak(boolean[] impossible, ArrayList<String> ans, char[] chars, int start, int end, Set<String> dict, String prefix, StringBuilder sb) {
		int len = end - start;
		if(len == 0){
			ans.add(sb.toString());
			return true;
		}
		boolean ret = false;
		for(int i = len; i >= 0; i--){
			String w = new String(chars, start, i);
			if(dict.contains(w) && (i == len || !impossible[start + i])){
				int prevLength = sb.length();
				sb.append(prefix);
				sb.append(w);
				if(wordBreak(impossible, ans, chars, start + i, end, dict, " ", sb)){
					ret = true;
				}else{
					impossible[start + i] = true;
				}
				sb.setLength(prevLength);
			}
		}
		return ret;
	}

	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> ans = new ArrayList<String>();
		if(dict.size() == 0) return ans;
		wordBreak(new boolean[s.length()], ans, s.toCharArray(), 0, s.length(), dict, "", new StringBuilder());
		return ans;
	}

	public static void main(String[] args){
		Set<String> input = new HashSet<String>(Arrays.asList(new String[]{"a","aa"}));

		System.err.println(new Solution().wordBreak("aaaaa", input));
	}
}