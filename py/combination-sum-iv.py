class Solution(object):
    def combinationSum4(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        table = dict()
        def dp(n):
            if n not in table:
                ans = 0
                for num in nums:
                    if num < n:
                        ans += dp(n - num)
                    if num == n:
                        ans += 1
                table[n] = ans
            return table[n]
        return dp(target)
