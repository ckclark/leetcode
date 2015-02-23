package leetcode.excel_sheet_column_title;

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
        	n--;
        	sb.append((char)('A' + (n % 26)));
        	n /= 26;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args){
    	System.err.println(new Solution().convertToTitle(704));
    }
}
