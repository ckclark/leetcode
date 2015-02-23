package leetcode.excel_sheet_column_number;

public class Solution {
	public int titleToNumber(String s) {
		if(s == null || s.length() == 0) return 0;
		int len = s.length();
		int n = 0;
		for(int i = 0; i < len; i++){
			n *= 26;
			n += s.charAt(i) - 'A';
			n++;
		}
		return n;
    }
	public static void main(String[] args){
		System.err.println(new Solution().titleToNumber("ZZ"));
	}
}
