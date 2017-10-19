class Solution(object):
    def findLengthOfLCIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        start = 0
        prev = None
        m = 0
        for i, n in enumerate(nums):
            if prev is not None:
                if n <= prev:
                    start = i
            m = max(m, i - start + 1)
            prev = n
        return m
