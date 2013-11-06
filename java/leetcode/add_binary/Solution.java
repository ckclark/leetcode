package leetcode.add_binary;

public class Solution {
    public String addBinary(String a, String b) {
    	if(a == null) a = "";
    	if(b == null) b = "";
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        char[] ans = new char[Math.max(ca.length, cb.length) + 1];
        int l_ca = ca.length;
        int l_cb = cb.length;
        int l_ans = ans.length;
        int carry = 0;
        for(int i = 0; i < l_ans; i++){
        	int va = 0, vb = 0;
        	if(i < l_ca){
        		va = ca[l_ca - 1 - i] == '1' ? 1 : 0;
        	}
        	if(i < l_cb){
        		vb = cb[l_cb - 1 - i] == '1' ? 1 : 0;
        	}
        	ans[l_ans - 1 - i] = (carry + va + vb) % 2 == 0 ? '0' : '1';
        	carry = (va + vb + carry) / 2;
        }
        int start;
        for(start = 0; start < l_ans - 1 && ans[start] == '0'; start++) System.err.println(ans[start]);
        return new String(ans, start, l_ans - start);
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().addBinary("11", "1"));
    }
}
