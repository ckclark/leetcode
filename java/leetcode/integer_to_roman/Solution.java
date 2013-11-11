package leetcode.integer_to_roman;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String intToRoman(int num) {
    	Map<Integer, String> map = new HashMap<Integer, String>();
    	StringBuilder sb = new StringBuilder();
    	String[] romans = new String[]{
    		"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
    		"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC",
    		"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM",
    		"M", "MM", "MMM",
    	};
    	for(int i = 0; i <= 9; i++){
    		map.put(i, romans[i]);
    	}
    	for(int i = 10; i <= 90; i += 10){
    		map.put(i, romans[i / 10 + 9]);
    	}
    	for(int i = 100; i <= 900; i += 100){
    		map.put(i, romans[i / 100 + 18]);
    	}
    	for(int i = 1000; i <= 3000; i += 1000){
    		map.put(i, romans[i / 1000 + 27]);
    	}
    	for(int x = 1000; x >= 1; x /= 10){
    		sb.append(map.get((num / x % 10) * x));
    	}
    	return sb.toString();
    }
    
    public static void main(String[] args){
    	for(int i = 1; i <= 3999; i++){
    		System.err.println(i + ":" + new Solution().intToRoman(i));
    	}
    }
}
