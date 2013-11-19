package leetcode.implement_strstr;

public class Solution {
	public int[] build_table(char[] haystack){
		int length = haystack.length;
		int[] table = new int[length];
		int pos = 2;
		int cnd = 0;
		table[0] = -1;
		if(table.length > 1)
			table[1] = 0;
		while(pos < length){
			if(haystack[pos - 1] == haystack[cnd]){
				table[pos++] = ++cnd;
			}else if(cnd > 0){
				cnd = table[cnd];
			}else{
				table[pos++] = 0;
			}
		}
		return table;
	}
	
    public String strStr(String haystack, String needle) {
    	if(haystack == null) return null;
    	if(needle.length() == 0) return haystack;
    	if(haystack.length() == 0) return null;
    	char[] S = haystack.toCharArray();
    	char[] W = needle.toCharArray();
        int[] T = build_table(W);
        int m = 0;
        int i = 0;
        while(m + i < S.length){
        	if(W[i] == S[m + i]){
        		if(i == W.length - 1){
        			return new String(S, m, S.length - m);
        		}
        		i++;
        	}else{
        		m = m + i - T[i];
        		if(T[i] > -1){
        			i = T[i];
        		}else{
        			i = 0;
        		}
        	}
        }
        return null;
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().strStr("aaa", "a"));
    }
}
