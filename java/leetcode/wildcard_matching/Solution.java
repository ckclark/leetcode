package leetcode.wildcard_matching;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {
	Map<Integer, Set<Integer>> visit;
	int[] remain;
	boolean getVisit(int key1, int key2){
		Set<Integer> s = visit.get(key1);
		if(s == null) return false;
		return s.contains(key2);
	}
	void setVisit(int key1, int key2){
		Set<Integer> s = visit.get(key1);
		if(s == null){
			s = new HashSet<Integer>();
			visit.put(key1, s);
		}
		s.add(key2);
	}
	
	public static class State{
		int s_cur, p_cur;
		public State(int s_cur, int p_cur){
			this.s_cur = s_cur;
			this.p_cur = p_cur;
		}
	}
	
	public boolean doMatch(char[] s, char[] p, int s_to, int p_to){
		Stack<State> stack = new Stack<State>();
		stack.push(new State(0, 0));
		while(!stack.isEmpty()){
			State st = stack.pop();
			int s_cur = st.s_cur;
			int p_cur = st.p_cur;
			if(getVisit(s_cur, p_cur)) continue;
			setVisit(s_cur, p_cur);
			if(s_cur == s_to && p_cur == p_to) return true;
			if(s_cur < s_to && p_cur == p_to){
				continue;
			}
			if(p[p_cur] != '*'){
				if(s_cur == s_to || (s[s_cur] != p[p_cur] && p[p_cur] != '?')){
					setVisit(s_cur, p_cur);
				}else{
					stack.push(new State(s_cur + 1, p_cur + 1));
				}
			}else{
				if(s_cur < s_to && remain[p_cur] <= s_to - s_cur - 1){
					stack.push(new State(s_cur + 1, p_cur));
				}
				stack.push(new State(s_cur, p_cur + 1));
			}
		}
		return false;
	}

	public boolean isMatch(String s, String p) {
		visit = new HashMap<Integer, Set<Integer>>();
		char[] charp = p.toCharArray();
		char[] chars = s.toCharArray();
		remain = new int[p.length()];
		int cnt = 0;
		for(int i = charp.length - 1; i >= 0; i--){
			if(charp[i] != '*')
				cnt++;
			remain[i] = cnt;
		}
		return doMatch(chars, charp, s.length(), p.length());
	}

	public static void main(String[] args){
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		sb2.append('*');
		for(int i = 0; i < 32000; i++){
			sb1.append("a");
			sb2.append("a");
		}
		sb2.append('*');
		System.err.println(new Solution().isMatch(sb1.toString(), sb2.toString()));
		System.err.println(new Solution().isMatch("bbbbaaaaaaabbaabababababbbbbabbbabbabbabbbabbaababbaabbbaaaababbbaaaaabbbbaaabaaabaaabbabaabababaabababababbbbbbabbaaaaaaababbbbaabbabbabababbbbaabbabbbbabbbbabbaaabaaaabaaabbbbbababaabababbaabaaaaaab", "*a*abab**b*aaa**a****a***aab*babb*b***b*a**babaaa*a***ab*b*b****ba*a*a****a**ba**a*****a*b*b*abaa*a*"));

	}
}
