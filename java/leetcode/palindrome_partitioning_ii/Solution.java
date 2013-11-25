package leetcode.palindrome_partitioning_ii;

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

    public int minCut(String s) {
    	if(s.length() == 0) return 0;
    	int[] maxPalinTable = new int[s.length() * 2 - 1];
    	buildTable(s.toCharArray(), maxPalinTable);
    	int[] cut = new int[s.length() + 1];
    	for(int i = 0; i < s.length() * 2 - 1; i++){
    		int palinLength = maxPalinTable[i];
    		int jumpStart = i / 2 - (palinLength + 1) / 2 + 1;
    		int jumpEnd = i / 2;
    		for(int j = jumpStart; j <= jumpEnd; j++){
    			int jumpLength = palinLength + jumpStart * 2 - j * 2;
    			if(cut[j + jumpLength] == 0 || cut[j + jumpLength] > cut[j] + 1){
    				cut[j + jumpLength] = cut[j] + 1;
    			}
    		}
    	}
    	return cut[s.length()] - 1;
    }
	

	public static void main(String[] args){
		System.err.println(new Solution().minCut("a"));
	}
}
