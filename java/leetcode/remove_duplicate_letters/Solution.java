package leetcode.remove_duplicate_letters;

import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        Stack<Character> stack = new Stack<Character>();
        boolean[] used = new boolean[26];
        for(char c : s.toCharArray()){
            count[c - 'a']--;
            if(!used[c - 'a']){
                while(!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0){
                    char p = stack.pop();
                    used[p - 'a'] = false;
                }
                stack.add(c);
                used[c - 'a'] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }
        return sb.toString();
    }
}
