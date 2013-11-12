package leetcode.roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int romanToInt(String s) {
		Map<String, Integer> map = new HashMap<String, Integer>();
    	String[] romans = new String[]{
    		"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
    		"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC",
    		"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM",
    		"M", "MM", "MMM",
    	};
    	for(int i = 0; i <= 9; i++){
    		map.put(romans[i], i);
    	}
    	for(int i = 10; i <= 90; i += 10){
    		map.put(romans[i / 10 + 9], i);
    	}
    	for(int i = 100; i <= 900; i += 100){
    		map.put(romans[i / 100 + 18], i);
    	}
    	for(int i = 1000; i <= 3000; i += 1000){
    		map.put(romans[i / 1000 + 27], i);
    	}
    	int offset = 0;
    	int ans = 0;
    	while(offset < s.length()){
    		for(int digits = Math.min(4, s.length() - offset); digits >= 1; digits--){
    			Integer val = map.get(s.substring(offset, offset + digits));
    			if(val != null){
    				ans += val;
    				offset += digits;
    				break;
    			}
    		}
    	}
    	return ans;
	}
	
	public static void main(String[] args){
		for(int i = 1; i <= 3999; i++){
			if(new Solution().romanToInt(new leetcode.integer_to_roman.Solution().intToRoman(i)) != i){
				System.err.println("failed at " + i);
			}else{
				System.err.println(new leetcode.integer_to_roman.Solution().intToRoman(i) + " " + i);
			}
		}
	}
}
