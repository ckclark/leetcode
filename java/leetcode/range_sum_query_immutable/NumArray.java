package leetcode.range_sum_query_immutable;

public class NumArray {
    private int[] subsum;

    public NumArray(int[] nums) {
        subsum = new int[nums.length + 1];
        int prev = 0;
        for(int i = 0; i < nums.length; i++){
            subsum[i + 1] = (prev += nums[i]);
        }
    }

    public int sumRange(int i, int j) {
        return subsum[j + 1] - subsum[i];
    }
}