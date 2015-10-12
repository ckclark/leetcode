package leetcode.word_pattern;

import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] char2Str = new String[26];
        HashMap<String, Integer> str2Char = new HashMap<String, Integer>();
        String[] splits = str.split(" +");
        if(splits.length != pattern.length()) return false;
        int length = splits.length;
        for(int i = 0; i < length; i++){
            String word = splits[i];
            char c = pattern.charAt(i);
            if(word.equals(char2Str[c - 'a'])) continue;
            if(str2Char.containsKey(word) || char2Str[c - 'a'] != null)
                return false;
            str2Char.put(word, (int)(c - 'a'));
            char2Str[c - 'a'] = word;
        }
        return true;
    }
}
