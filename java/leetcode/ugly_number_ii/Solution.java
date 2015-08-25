package leetcode.ugly_number_ii;

public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[1691];
        int ug_2 = 0, ug_3 = 0, ug_5 = 0;
        ugly[0] = 1;
        for(int i = 1; i < 1691; i++){
            int nxt = Math.min(ugly[ug_2] * 2, Math.min(ugly[ug_3] * 3, ugly[ug_5] * 5));
            ugly[i] = nxt;
            if(nxt == ugly[ug_2] * 2) ug_2++;
            if(nxt == ugly[ug_3] * 3) ug_3++;
            if(nxt == ugly[ug_5] * 5) ug_5++;
        }
        return ugly[n - 1];
    }
}
