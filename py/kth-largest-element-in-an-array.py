import random
class Solution(object):
    def findKthLargest(self, nums, k, start=0, end=None):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        l = len(nums)
        if end is None:
            end = l

        if end == start + 1:
            return nums[start]

        pivot = nums[random.randint(start, end - 1)]
        i, j, n = start, start, end - 1
        while j <= n:
            if nums[j] < pivot:
                if i != j:
                    nums[i], nums[j] = nums[j], nums[i]
                i += 1
                j += 1
            elif nums[j] > pivot:
                if j != n:
                    nums[j], nums[n] = nums[n], nums[j]
                n -= 1
            else:
                j += 1
        if i <= l - k < j:
            return nums[-k]
        if l - k < i:
            return self.findKthLargest(nums, k, start, i)
        else:
            return self.findKthLargest(nums, k, j, end)
