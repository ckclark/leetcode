class Solution(object):
    def PredictTheWinner(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        dp = dict()
        def top_down(start, end):
            if start == end:
                dp[start, end] = 0
            elif (start, end) not in dp:
                dp[start, end] = max(nums[start] - top_down(start + 1, end), nums[end - 1] - top_down(start, end - 1))
            return dp[start, end]

        return top_down(0, len(nums)) >= 0
