package leetcode.happy_number;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        if(n <= 0) return false;
        Set<Integer> appeared = new HashSet<Integer>();
        while(!appeared.contains(n)){
            appeared.add(n);
            int s = 0;
            while(n > 0){
                s += (n % 10) * (n % 10);
                n /= 10;
            }
            n = s;
        }
        return n == 1;
    }
}