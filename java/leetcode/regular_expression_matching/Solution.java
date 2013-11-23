package leetcode.regular_expression_matching;

public class Solution {
	public boolean doMatch(char[] s, char[] p, int s_cur, int s_to, int p_cur, int p_to){
		if(s_cur == s_to && p_cur == p_to) return true;
		if(s_cur < s_to && p_cur == p_to) return false;
		if(p_cur + 1 >= p_to || p[p_cur + 1] != '*'){
			if(s_cur == s_to || (s[s_cur] != p[p_cur] && p[p_cur] != '.')){
				return false;
			}else{
				return doMatch(s, p, s_cur + 1, s_to, p_cur + 1, p_to);
			}
		}else{
			if(s_cur < s_to){
				if(p[p_cur] == s[s_cur] || p[p_cur] == '.'){
					if(doMatch(s, p, s_cur + 1, s_to, p_cur, p_to)) return true;
				}
			}
			return doMatch(s, p, s_cur, s_to, p_cur + 2, p_to);
		}
	}

	public boolean isMatch(String s, String p) {
		return doMatch(s.toCharArray(), p.toCharArray(), 0, s.length(), 0, p.length());
	}

	public static void main(String[] args){
		System.err.println(new Solution().isMatch("", ".*"));
	}
}
