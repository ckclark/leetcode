package leetcode.valid_palindrome;

public class Solution {
    public boolean isPalindrome(String s) {
    	if(s == null) return true;
    	char[] chars = s.toCharArray();
    	int length = chars.length;
    	int left = 0, right = length - 1;
    	while(left < right){
    		char lch = chars[left];
    		char rch = chars[right];
    		boolean ready = true;
    		if(!Character.isDigit(lch) && !Character.isLetter(lch)){
    			left++;
    			ready = false;
    		}
    		if(!Character.isDigit(rch) && !Character.isLetter(rch)){
    			right--;
    			ready = false;
    		}
    		if(ready){
    			if(Character.toLowerCase(lch) != Character.toLowerCase(rch)) return false;
    			left++;
    			right--;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().isPalindrome("abc ba"));
    }
}
