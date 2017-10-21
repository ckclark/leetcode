class Solution(object):
    def thirdMax(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        M1, m = max(nums), min(nums)
        if M1 == m:
            return M1
        M2 = max(nums, key=lambda x:m - 1 if x >= M1 else x)
        if M2 <= m:
            return M1
        M3 = max(nums, key=lambda x:m - 1 if x >= M2 else x)
        return M3
