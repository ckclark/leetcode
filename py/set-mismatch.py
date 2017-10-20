class Solution(object):
    def findErrorNums(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for i, n in enumerate(nums, 1):
            while i != n and nums[n - 1] != n:
                nums[i - 1], nums[n - 1] = nums[n - 1], nums[i - 1]
                n = nums[i - 1]
        for i, n in enumerate(nums, 1):
            if i != n:
                return [n, i]
