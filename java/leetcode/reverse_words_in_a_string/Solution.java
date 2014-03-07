package leetcode.reverse_words_in_a_string;

import java.util.Stack;

public class Solution {
	public String reverseWords(String s) {
		Stack<String> ans = new Stack<String>();
        for(String word : s.split(" ")){
        	if(!word.isEmpty()){
        		ans.push(word);
        	}
        }
        String prefix = "";
        StringBuilder sb = new StringBuilder();
        while(!ans.isEmpty()){
        	sb.append(prefix);
        	sb.append(ans.pop());
        	prefix = " ";
        }
        return sb.toString();
    }

	public static void main(String[] args){
		System.err.println(new Solution().reverseWords(" the sky is blue   "));
	}
}
