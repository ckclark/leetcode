package leetcode.additive_number;

import java.math.BigInteger;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        int length = num.length();
        if(length < 3){
            return false;
        }
        for(int l1 = 1; l1 <= length / 2; l1++){
            for(int l2 = 1; l2 <= (length - l1) / 2; l2++){
                if(length - l1 - l2 < Math.max(l1, l2)) break;
                if(isAdditiveNumberInternal(num, l1, l2))
                    return true;
            }
        }
        return false;
    }

    private boolean isAdditiveNumberInternal(String num, int l1, int l2) {
        int length = num.length();
        String n1 = num.substring(0, l1);
        String n2 = num.substring(l1, l1 + l2);
        if((l1 > 1 && n1.charAt(0) == '0') || (l2 > 1 && n2.charAt(0) == '0'))
            return false;
        BigInteger b1 = new BigInteger(n1);
        BigInteger b2 = new BigInteger(n2);
        int cur = l1 + l2;
        while(true){
            if(cur == length) return true;
            BigInteger bnext = b1.add(b2);
            String nxt = bnext.toString();
            int lnxt = nxt.length();
            if(cur + lnxt > length){
                return false;
            }else{
                if(num.substring(cur, cur + lnxt).equals(nxt)){
                    cur += lnxt;
                    b1 = b2;
                    b2 = bnext;
                }else{
                    return false;
                }
            }
            
        }
    }
}
