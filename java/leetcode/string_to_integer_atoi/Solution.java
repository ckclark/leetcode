package leetcode.string_to_integer_atoi;

public class Solution {
    public int atoi(String str) {
    	if(str == null || str.length() == 0) return 0;
        char[] chars = str.trim().toCharArray();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        boolean negative = false;
        if(chars[idx] == '+'){
        	idx++;
        }
        if(chars[idx] == '-'){
        	idx++;
        	negative = true;
        }
        boolean nonZero = false;
        boolean containDigit = false;
        for(;idx < chars.length && Character.isDigit(chars[idx]); idx++){
        	containDigit = true;
        	if(chars[idx] != '0'){
        		nonZero = true;
        	}
        	if(nonZero)
        		sb.append(chars[idx]);
        }
        if(!containDigit) return 0;
        if(sb.length() > 10){
        	if(negative) return Integer.MIN_VALUE;
        	else return Integer.MAX_VALUE;
        }else{
        	if(sb.length() == 10){
        		if(negative){
        			if(sb.toString().compareTo("2147483648") > 0)
        				return Integer.MIN_VALUE;
        		}else{
        			if(sb.toString().compareTo("2147483647") > 0)
        				return Integer.MAX_VALUE;
        		}
        	}
        	int ret = 0;
        	for(char c : sb.toString().toCharArray()){
        		ret *= 10;
        		ret += c - '0';
        	}
        	if(negative)
        		ret = -ret;
        	return ret;
        }
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().atoi("   214748364777"));
    }
}
