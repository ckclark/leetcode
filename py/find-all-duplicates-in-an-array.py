class Solution(object):
    def findDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for i, n in enumerate(nums, 1):
            while n != i and nums[n - 1] != n:
                nums[n - 1], nums[i - 1], n = nums[i - 1], nums[n - 1], nums[n - 1]

        return [n for i, n in enumerate(nums, 1) if n != i]
