package leetcode.burst_balloons;

public class Solution {
    public int maxCoins(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int[] nums_padding = new int[n + 2];
        nums_padding[0] = nums_padding[n + 1] = 1;
        for(int i = 0; i < n; i++){
            nums_padding[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 1][];
        for(int i = 1; i <= n; i++){
            dp[i] = new int[n - i + 2];
        }
        for(int i = 1; i <= n; i++){
            dp[i][1] = nums_padding[i - 1] * nums_padding[i] * nums_padding[i + 1];
        }
        for(int l = 2; l <= n; l++){
            for(int i = 1; i <= n - l + 1; i++){
                int val;
                val = dp[i + 1][l - 1] + nums_padding[i - 1] * nums_padding[i] * nums_padding[i + l];
                if(val > dp[i][l])
                    dp[i][l] = val;
                val = dp[i][l - 1] + nums_padding[i - 1] * nums_padding[i + l - 1] * nums_padding[i + l];
                if(val > dp[i][l])
                    dp[i][l] = val;
                for(int j = 1; j < l - 1; j++){
                    val = dp[i][j] + dp[i + j + 1][l - j - 1] + nums_padding[i - 1] * nums_padding[i + j] * nums_padding[i + l];
                    if(val > dp[i][l])
                        dp[i][l] = val;
                }
            }
        }
        return dp[1][n];
    }
}
