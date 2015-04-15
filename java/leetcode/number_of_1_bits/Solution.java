package leetcode.number_of_1_bits;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        n = n - ((n >> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
        return (((n + (n >> 4)) & 0x0F0F0F0F) * 0x01010101) >> 24;
    }
    
    public static void main(String[] args){
        System.err.println(new Solution().hammingWeight(-1));
    }
}
