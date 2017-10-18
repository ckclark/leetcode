class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = 0
        m = 0
        for c in nums:
            if c == 0:
                n = 0
            else:
                n += 1
            m = max(n, m)
        return m

