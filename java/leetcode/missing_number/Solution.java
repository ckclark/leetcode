package leetcode.missing_number;

public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int xorall = 0;
        int t = 1;
        if(n % 4 == 2 || n % 4 == 3)
            xorall = 1;
        for(int i = 1; i < 31; i++){
            t |= (1 << i);
            int rem = n & t;
            if(rem >= 1 << i){
                if(rem % 2 == 1){
                    xorall |= (1 << i);
                }
            }
        }
        for(int x : nums){
            xorall ^= x;
        }
        return xorall;
    }
}
