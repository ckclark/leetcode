package leetcode.valid_number;

public class Solution {

	public boolean isExponent(String s){
		if(s.length() == 0) return false;
		int first = s.toLowerCase().indexOf('e');
		int last = s.toLowerCase().lastIndexOf('e');
		if(first != last) return false;
		if(first < 0) return false;
		return isFloat(s.substring(0, first)) && isInteger(s.substring(first + 1));
	}
	
	public boolean isFloat(String s){
		if(s.length() == 0) return false;
		if(isInteger(s)) return true;
		int first = s.indexOf('.');
		int last = s.lastIndexOf('.');
		if(first != last) return false;
		if(first < 0) return false;
		int start = 0;
		if(s.charAt(0) == '+' || s.charAt(0) == '-') start = 1;
		if(isAllDigit(s.substring(start, first), true) && isAllDigit(s.substring(first + 1), false)) return true;
		if(isAllDigit(s.substring(start, first), false) && isAllDigit(s.substring(first + 1), true)) return true;
		return false;
	}
	
	public boolean isAllDigit(String s, boolean canBeEmpty){
		if(s.length() == 0 && !canBeEmpty) return false;
		char [] chars = s.toCharArray();
		for(int i = 0; i < chars.length; i++){
			char c = chars[i];
			if(!Character.isDigit(c)) return false;
		}
		return true;
	}
	
	public boolean isInteger(String s){
		if(s.length() == 0) return false;
		char[] chars = s.toCharArray();
		if(chars[0] == '+' || chars[0] == '-') return isAllDigit(s.substring(1), false);
		return isAllDigit(s, false);
	}
	
    public boolean isNumber(String s) {
    	s = s.trim();
    	if(s.length() == 0) return false;
    	// floating point
    	if(isFloat(s)) return true;
    	// Exponent +1e10
    	if(isExponent(s)) return true;
    	return false;
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().isNumber("-."));
    }
}
