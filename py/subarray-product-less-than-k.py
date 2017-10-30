class Solution(object):
    def numSubarrayProductLessThanK(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        ans = 0
        subproduct = 1
        if k <= 1:
            return 0
        start, end = 0, 0
        while start < len(nums) or end < len(nums):
            if subproduct < k:
                ans += end - start
                if end < len(nums):
                    subproduct *= nums[end]
                    end += 1
                else:
                    break
            else:
                subproduct /= nums[start]
                start += 1
        return ans
