package leetcode.fraction_to_recurring_decimal;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public String fractionToDecimal(int numerator, int denominator) {
		long lnumerator = numerator;
		long ldenominator = denominator;
		boolean negative = false;
		if(lnumerator > 0 && ldenominator < 0) negative = true;
		if(lnumerator < 0 && ldenominator > 0) negative = true;
		lnumerator = Math.abs(lnumerator);
		ldenominator = Math.abs(ldenominator);
		StringBuilder sb = new StringBuilder();
		if(negative) sb.append("-");
		sb.append(lnumerator / ldenominator);
		long remainder = lnumerator % ldenominator;
		if(remainder > 0){
			sb.append(".");
			StringBuilder afterDecimalPoint = new StringBuilder();
			Map<Long, Integer> pos = new HashMap<Long, Integer>();
			for(int p = 0; !pos.containsKey(remainder) && remainder > 0; p++){
				pos.put(remainder, p);
				remainder *= 10;
				afterDecimalPoint.append(remainder / ldenominator);
				remainder = remainder % ldenominator;
			}
			if(remainder > 0){
				int p = pos.get(remainder);
				afterDecimalPoint.insert(p, "(");
				afterDecimalPoint.append(")");
			}
			sb.append(afterDecimalPoint);
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		System.err.println(new Solution().fractionToDecimal(1, -2147483647));
	}
}
