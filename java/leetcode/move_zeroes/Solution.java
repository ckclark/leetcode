package leetcode.move_zeroes;

public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null) return;
        int size = nums.length;
        if(size <= 1) return;
        int last0 = 0;
        for(int i = 0; i < size; i++){
            if(nums[i] != 0){
                if(i != last0){
                    nums[last0] = nums[i];
                    nums[i] = 0;
                }
                last0++;
            }
        }
    }
}
