package leetcode.generate_parentheses;

import java.util.ArrayList;

public class Solution {
	public static void dfs(int n, int depth, int stack, StringBuilder sb, ArrayList<String> ary){
		if(depth == 2 * n){
			ary.add(sb.toString());
		}else{
			if(stack > 0){
				sb.append(')');
				dfs(n, depth + 1, stack - 1, sb, ary);
				sb.setLength(sb.length() - 1);
			}
			if(depth + stack < n * 2){
				sb.append('(');
				dfs(n, depth + 1, stack + 1, sb, ary);
				sb.setLength(sb.length() - 1);
			}
		}
	}
	
    public ArrayList<String> generateParenthesis(int n) {
    	ArrayList<String> ary = new ArrayList<String>();
        dfs(n, 0, 0, new StringBuilder(), ary);
        return ary;
    }
    
    public static void main(String[] args){
    	ArrayList<String> ans = new Solution().generateParenthesis(4);
    	for(String s : ans){
    		System.err.println(s);
    	}
    }
}
