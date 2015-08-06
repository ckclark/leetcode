package leetcode.valid_anagram;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] bucket = new int[26];
        for(char c : s.toCharArray()){
            bucket[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            bucket[c - 'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(bucket[i] != 0) return false;
        }
        return true;
    }
}
