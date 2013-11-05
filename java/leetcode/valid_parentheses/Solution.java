package leetcode.valid_parentheses;

public class Solution {
	public boolean isValid(String s) {
		StringBuilder sb = new StringBuilder();
		for(char c : s.toCharArray()){
			switch(c){
			case '(':
				sb.append(c);
				break;
			case '[':
				sb.append(c);
				break;
			case '{':
				sb.append(c);
				break;
			case ')':
				if(sb.length() > 0 && sb.charAt(sb.length() - 1) == '('){
					sb.setLength(sb.length() - 1);
				}else return false;
				break;
			case ']':
				if(sb.length() > 0 && sb.charAt(sb.length() - 1) == '['){
					sb.setLength(sb.length() - 1);
				}else return false;
				break;
			case '}':
				if(sb.length() > 0 && sb.charAt(sb.length() - 1) == '{'){
					sb.setLength(sb.length() - 1);
				}else return false;
				break;
			}
		}
		return sb.length() == 0;
	}
	
	public static void main(String[] args){
		System.err.println("ans: " + new Solution().isValid("{([][)]()()[][][]{}{}{}}"));
	}
}
