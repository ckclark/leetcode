class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums) == 1:
            return 0 if nums[0] == target else -1
        if target >= nums[0]:
            L, U = -1, len(nums)
            while L + 1 < U:
                mid = L + (U - L) / 2
                if nums[mid] > target or nums[mid] < nums[0]:
                    U = mid
                else:
                    L = mid
            return L if nums[L] == target else -1
        elif target <= nums[-1]:
            L, U = -1, len(nums)
            while L + 1 < U:
                mid = L + (U - L) / 2
                if nums[mid] <= target or nums[mid] > nums[-1]:
                    L = mid
                else:
                    U = mid
            return L if nums[L] == target else -1
        else:
            return -1
