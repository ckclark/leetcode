package leetcode.longest_increasing_subsequence;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] minTailForLength = new int[nums.length];
        int length = 0;
        for(int x : nums){
            int L = -1, U = length;
            while(L + 1 < U){
                int mid = L + (U - L) / 2;
                if(minTailForLength[mid] < x){
                    L = mid;
                }else{
                    U = mid;
                }
            }
            minTailForLength[U] = x;
            if(U == length){
                length++;
            }
        }
        return length;
    }
}