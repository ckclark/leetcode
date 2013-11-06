package leetcode.length_of_last_word;

public class Solution {
    public int lengthOfLastWord(String s) {
    	if(s == null || s.length() == 0) return 0;
    	char[] chars = s.toCharArray();
    	int endIdx = -1, startIdx = -1;
    	for(int i = chars.length - 1; i >= 0; i--){
    		if(endIdx == -1){
	    		if(chars[i] != ' '){
	    			endIdx = i; 
	    		}
    		}else if(startIdx == -1){
    			if(chars[i] == ' '){
    				startIdx = i;
    				break;
    			}
    		}
    	}
    	return endIdx - startIdx;
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().lengthOfLastWord("hello"));
    	System.err.println(new Solution().lengthOfLastWord("hello "));
    	System.err.println(new Solution().lengthOfLastWord(" hello"));
    	System.err.println(new Solution().lengthOfLastWord("hello worlddd"));
    	System.err.println(new Solution().lengthOfLastWord("hello worlddd "));
    	System.err.println(new Solution().lengthOfLastWord(" hello worlddd"));
    	System.err.println(new Solution().lengthOfLastWord(" hello worlddd "));
    	System.err.println(new Solution().lengthOfLastWord("  "));
    }
}
