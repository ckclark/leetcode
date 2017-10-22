class Solution(object):
    def singleNonDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ln = len(nums)
        L, U = -1, ln
        while L + 1 < U:
            mid = L + (U - L) / 2
            if mid == ln - 1:
                return nums[mid]
            other = mid / 2 * 2 + 1 - (mid % 2)
            if nums[other] == nums[mid]:
                L = mid
            else:
                U = mid
        return nums[U / 2 * 2]
