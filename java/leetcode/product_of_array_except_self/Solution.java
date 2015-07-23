package leetcode.product_of_array_except_self;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        int prev;
        prev = 1;
        for(int i = length - 1; i >= 0; i--){
            prev *= nums[i];
            ans[i] = prev;
        }
        prev = 1;
        for(int i = 0; i < length; i++){
            prev *= nums[i];
            nums[i] = prev;
        }
        for(int i = 0; i < length; i++){
            int m = 1;
            if(i > 0)
                m *= nums[i - 1];
            if(i < length - 1){
                m *= ans[i + 1];
            }
            ans[i] = m;
        }
        return ans;
    }
}
