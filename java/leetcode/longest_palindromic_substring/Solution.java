package leetcode.longest_palindromic_substring;

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
	
    public String longestPalindrome(String s) {
    	if(s == null || s.length() == 0) return "";
    	char[] charAry = s.toCharArray();
    	int[] table = new int[charAry.length * 2 - 1];
    	buildTable(charAry, table);
    	int max = 0, maxi = -1;
    	for(int i = 0; i < charAry.length * 2 - 1; i++){
    		if(table[i] > max){
    			max = table[i];
    			maxi = i;
    		}
    	}
    	int start = (maxi - max + 1) / 2;
    	return s.substring(start, start + max);
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().longestPalindrome("aabcefghijkfkeqomieoqiemieonewfhnajvnzjfhneufhqeufhqieufhqeuhfefhpfmefpoqfelmmnopqrstuvwxz"));
    }
}
