package leetcode.single_number_iii;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int xorall = 0;
        for(int x : nums){
            xorall ^= x;
        }
        int leastdiffbit = xorall & -xorall;
        int a = 0, b = 0;
        for(int x : nums){
            if((x & leastdiffbit) != 0){
                a ^= x;
            }else{
                b ^= x;
            }
        }
        return new int[]{a, b};
    }
}
