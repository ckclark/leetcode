package leetcode.palindrome_partitioning;

import java.util.ArrayList;

public class Solution {
	
	public void buildTable(char[] charAry, int[] table){
		int L = 0, R = -1, C = 0;
		int len = charAry.length;
		for(int i = 0; i < len * 2 - 1; i++){
			int ref = 2 * C - i;
			if(i > R || ref - table[ref] + 1 <= L){
				int rad;
				int minrad = i > R ? 1 : R - i + 1;
				if(minrad > len * 2 - i) minrad = len * 2 - i;
				C = i;
				for(rad = minrad; i - rad + 1 >= 0 && i + rad - 1 < len * 2 - 1; rad++){
					int l = i - rad + 1, r = i + rad - 1;
					if(l % 2 == 1 || charAry[l / 2] == charAry[r / 2]){
						table[i] = rad;
						R = i + rad - 1;
						L = i - rad + 1; 
					}else{
						break;
					}
				}
			}else{
				table[i] = table[ref];
			}
		}
		for(int i = 0; i < len * 2 - 1; i++){
			if(i % 2 == 0){
				table[i] = (table[i] - 1) / 2 * 2 + 1;
			}else{
				table[i] = table[i] / 2 * 2;
			}
		}
	}

	private void dfs(ArrayList<ArrayList<String>> ans, ArrayList<String> cur, char[] charArray, int[] maxPalinTable, int depth) {
		if(depth == charArray.length){
			ans.add(new ArrayList<String>(cur));
		}else{
			for(int len = 1; depth + len <= charArray.length; len++){
				int center = 2 * depth + len - 1;
				if(maxPalinTable[center] >= len){
					cur.add(new String(charArray, depth, len));
					dfs(ans, cur, charArray, maxPalinTable, depth + len);
					cur.remove(cur.size() - 1);
				}
			}
		}
	}
	
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		if(s == null) return ans;
		if(s.length() == 0){
			ans.add(new ArrayList<String>());
			return ans;
		}
		int[] maxPalinTable = new int[s.length() * 2 - 1];
		buildTable(s.toCharArray(), maxPalinTable);
		dfs(ans, new ArrayList<String>(), s.toCharArray(), maxPalinTable, 0);
//		for(int i = 0; i < s.length() * 2 - 1; i++){
//			if(i % 2 == 0){
//				System.err.print(s.charAt(i / 2) + " ");
//			}else{
//				System.err.print("# ");
//			}
//		}
//		System.err.println("");
//		for(int x : maxPalinTable){
//			System.err.print(String.format("%-2d", x));
//		}
//		System.err.println("");
		return ans;
	}
	

	public static void main(String[] args){
		for(ArrayList<String> row : new Solution().partition("cbbbcc")){
			for(String s : row){
				System.err.print(s + ",");
			}
			System.err.println("");
		}
	}
}
