class Solution(object):
    def largestDivisibleSubset(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if not nums:
            return []
        nums.sort(reverse=True)
        lnums = len(nums)
        dp = [(-1, 1)] * lnums
        max_length, max_end = 1, 0
        for i, n in enumerate(nums):
            for j in xrange(i + 1, lnums):
                if n % nums[j] == 0:
                    if dp[j][1] < dp[i][1] + 1:
                        dp[j] = i, dp[i][1] + 1
                        if dp[j][1] > max_length:
                            max_length, max_end = dp[j][1], j
        cur = max_end
        ans = []
        while cur != -1:
            ans.append(nums[cur])
            cur = dp[cur][0]
        return ans
