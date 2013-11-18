package leetcode.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	
	public ArrayList<String> dfs(HashMap<Character, char[]> digitMap, char[] str, int depth, int size, StringBuilder sb){
		ArrayList<String> ans = new ArrayList<String>();
		if(depth == size){
			ans.add(sb.toString());
			return ans;
		}else{
			if(str[depth] == '1'){
				ans.addAll(dfs(digitMap, str, depth + 1, size, sb));
			}else{
				for(char c : digitMap.get(str[depth])){
					sb.append(c);
					ans.addAll(dfs(digitMap, str, depth + 1, size, sb));
					sb.deleteCharAt(sb.length() - 1);
				}
			}
		}
		return ans;
	}
	
    public ArrayList<String> letterCombinations(String digits) {
        HashMap<Character, char[]> digitMap = new HashMap<Character, char[]>();
        digitMap.put('0', " ".toCharArray());
        digitMap.put('1', "".toCharArray());
        digitMap.put('2', "abc".toCharArray());
        digitMap.put('3', "def".toCharArray());
        digitMap.put('4', "ghi".toCharArray());
        digitMap.put('5', "jkl".toCharArray());
        digitMap.put('6', "mno".toCharArray());
        digitMap.put('7', "pqrs".toCharArray());
        digitMap.put('8', "tuv".toCharArray());
        digitMap.put('9', "wxyz".toCharArray());
        
        return dfs(digitMap, digits.toCharArray(), 0, digits.length(), new StringBuilder());
    }
    
    public static void main(String[] args){
    	for(String s : new Solution().letterCombinations("234012")){
    		System.err.println(s);
    	}
    }
}
