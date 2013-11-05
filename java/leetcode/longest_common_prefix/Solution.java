package leetcode.longest_common_prefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
    	if(strs == null || strs.length == 0) return "";
    	StringBuilder sb = new StringBuilder();
    	int minlength;
    	if(strs[0] == null) minlength = 0;
    	else{
    		minlength = strs[0].length();
    		for(int i = 1; i < strs.length; i++){
    			minlength = Math.min(minlength, strs[i] == null ? 0: strs[i].length());
    		}
    	}
    	for(int i = 0; i < minlength; i++){
    		char c = strs[0].charAt(i);
    		for(int j = 1; j < strs.length; j++){
    			if(strs[j].charAt(i) != c) return sb.toString();
    		}
    		sb.append(c);
    	}
    	return sb.toString();
    }
    
    public static void main(String[] args){
    	String[] strs = new String[]{"abab","aba","abc"};
    	System.err.println(new Solution().longestCommonPrefix(strs));
    }
}
