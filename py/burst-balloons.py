from collections import defaultdict

class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0

        n = len(nums)

        nums.append(1)

        dp = defaultdict(int)
        for i in xrange(n):
            dp[i, 1] = nums[i - 1] * nums[i] * nums[i + 1]

        for l in xrange(2, n + 1):
            for i in xrange(n - l + 1):
                dp[i, l] = max(dp[i, l], dp[i + 1, l - 1] + nums[i - 1] * nums[i] * nums[i + l])
                dp[i, l] = max(dp[i, l], dp[i, l - 1] + nums[i - 1] * nums[i + l - 1] * nums[i + l])
                for j in xrange(1, l - 1):
                    dp[i, l] = max(dp[i, l], dp[i, j] + dp[i + j + 1, l - j - 1] + nums[i - 1] * nums[i + j] * nums[i + l])
        return dp[0, n]

