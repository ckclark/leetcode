package leetcode.house_robber_ii;

public class Solution {
    public int rob(int[] nums) {
        int rob, notrob;
        int sol1, sol2;
        if(nums == null || nums.length == 0) return 0;
        rob = nums[0];
        notrob = 0;
        for(int i = 1; i < nums.length - 1; i++){
            int n_notrob = Math.max(rob, notrob);
            int n_rob = notrob + nums[i];
            rob = n_rob;
            notrob = n_notrob;
        }
        sol1 = Math.max(rob, notrob);

        rob = 0;
        notrob = 0;
        for(int i = 1; i < nums.length; i++){
            int n_notrob = Math.max(rob, notrob);
            int n_rob = notrob + nums[i];
            rob = n_rob;
            notrob = n_notrob;
        }
        sol2 = Math.max(rob, notrob);
        return Math.max(sol1, sol2);
    }
}
