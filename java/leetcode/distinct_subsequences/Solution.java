package leetcode.distinct_subsequences;

public class Solution {
	public int numDistinct(String S, String T) {
		if(S == null || T == null) return 1;
		char[] cs = S.toCharArray();
		char[] ct = T.toCharArray();
		int lens = cs.length;
		int lent = ct.length;
		int[][] table = new int[lens + 1][lent + 1];
		for(int i = 0; i <= lens; i++){
			for(int j = 0; j <= i && j <= lent; j++){
				if(j == 0){
					table[i][j] = 1;
				}else{
					table[i][j] = table[i - 1][j];
					if(cs[i - 1] == ct[j - 1]){
						table[i][j] += table[i - 1][j - 1];
					}
				}
			}
		}
		return table[lens][lent];
	}
	
	public static void main(String[] args){
		System.err.println(new Solution().numDistinct("aaabbbaaabbbaaa", "ababa"));
	}
}
