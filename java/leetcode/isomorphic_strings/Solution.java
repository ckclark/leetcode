package leetcode.isomorphic_strings;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int idx;
        
        int[] charMapS = new int[128];
        int[] codeS = new int[s.length()];
        char[] charS = s.toCharArray();
        idx = 0;
        for(int i = 0; i < charS.length; i++){
            char c = charS[i];
            if(charMapS[c] == 0){
                charMapS[c] = ++idx;
            }
            codeS[i] = charMapS[c];
        }

        int[] charMapT = new int[128];
        char[] charT = t.toCharArray();
        idx = 0;
        for(int i = 0; i < charT.length; i++){
            char c = charT[i];
            if(charMapT[c] == 0){
                charMapT[c] = ++idx;
            }
            if(codeS[i] != charMapT[c]) return false;
        }
        return true;
    }
}
