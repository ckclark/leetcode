package leetcode.minimum_size_subarray_sum;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = 0;
        int sum = 0;
        if(nums == null || nums.length == 0 || s == 0) return 0;
        int len = nums.length;
        int minlen = nums.length + 1;
        for(start = 0; start < len; start++){
            sum += nums[start];
            while(sum >= s){
                minlen = Math.min(minlen, start - end + 1);
                sum -= nums[end++];
            }
        }
        if(minlen == nums.length + 1){
            minlen = 0;
        }
        return minlen;
    }
}