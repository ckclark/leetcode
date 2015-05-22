package leetcode.bitwise_and_of_numbers_range;

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int ans = 0;
        for(int i = 0; i < 31; i++){
            if((m & ~((1 << i) - 1)) == (n & ~((1 << i) - 1))){
                ans |= (1 << i) & m;
            }
        }
        return ans;
    }
}