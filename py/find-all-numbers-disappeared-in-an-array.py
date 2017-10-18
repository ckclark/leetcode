class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for i, v in enumerate(nums, 1):
            while v != i:
                a, b = i - 1, v - 1
                if nums[a] != nums[b]:
                    nums[a], nums[b] = nums[b], nums[a]
                else:
                    break
                v = nums[i - 1]
        ans = []
        for i, v in enumerate(nums, 1):
            if v != i:
                ans.append(i)
        return ans
