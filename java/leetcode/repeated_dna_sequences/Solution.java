package leetcode.repeated_dna_sequences;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public String toATCG(int n){
		StringBuilder sb = new StringBuilder();
		String ATCG = "ATCG";
		for(int i = 9; i >= 0; i--){
			int v = (n >> (2 * i)) & 3;
			sb.append(ATCG.charAt(v));
		}
		return sb.toString();
	}
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new ArrayList<String>();
        byte[] appeared = new byte[0x100000];
        s = s.replace("A", "0").replace("T", "1").replace("C", "2").replace("G", "3");
        if(s.length() < 10){
        	return ret;
        }
        int n = 0;
        for(int i = 0; i < 9; i++){
        	n *= 4;
        	n += s.charAt(i) - '0';
        }
        for(int i = 9; i < s.length(); i++){
        	n *= 4;
        	n += s.charAt(i) - '0';
        	n &= 0xFFFFF;
        	if(appeared[n] < 2){
        		if(appeared[n] == 1){
        			ret.add(toATCG(n));
        		}
        		appeared[n]++;
        	}
        }
        return ret;
    }
    public static void main(String[] args){
    	System.err.println(new Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
