package leetcode.longest_substring_without_repeating_characters;

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
	public int lengthOfLongestSubstring(String s) {
		if(s == null) return 0;
		char[] charAry = s.toCharArray();
		Map<Character, MutableInt> map = new HashMap<Character, MutableInt>();
		int len = s.length();
		int left = 0;
		int maxlen = 0;
		for(int i = 0; i < len; i++){
			char c = charAry[i];
			MutableInt mi = map.get(c);
			if(mi == null){
				mi = new MutableInt();
				map.put(c, mi);
			}
			mi.increment();
			while(map.get(c).get() > 1){
				map.get(charAry[left++]).decrement();
			}
			if(i - left + 1 > maxlen) maxlen = i - left + 1;
		}
		return maxlen;
	}
	
	public static void main(String[] args){
		System.err.println(new Solution().lengthOfLongestSubstring("jfkadjfijasdfjklqeijifjifjdklfjdklajfffffjajkajkfla;"));
	}
}
