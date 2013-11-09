package leetcode.zigzag_conversion;

public class Solution {
    public String convert(String s, int nRows) {
    	if(s == null || s.length() == 0 || nRows <= 1) return s;
    	StringBuilder ans = new StringBuilder();
    	char[] input = s.toCharArray();
    	int length = input.length;
    	int cycle = 2 * nRows - 2;
        for(int row = 0; row < nRows; row++){
        	if(row == 0){
        		for(int i = 0; i < length; i += cycle){
        			ans.append(input[i]);
        		}
        	}else if(row < nRows - 1){
        		for(int i = row; i < length; i += cycle){
        			ans.append(input[i]);
        			int mirror = i + cycle - (i % cycle) * 2;
        			if(mirror < length)
        				ans.append(input[mirror]);
        		}
        	}else{
        		for(int i = row; i < length; i += cycle){
        			ans.append(input[i]);
        		}
        	}
        }
        return ans.toString();
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().convert("abcdefghijklmnopqrstuvwxyz", 1));
    }
}
