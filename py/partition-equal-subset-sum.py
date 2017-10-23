class Solution(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        s = sum(nums)
        if s % 2 != 0:
            return False
        possible = [True] + [False] * (s / 2 - 1)
        for n in nums:
            if n > s / 2:
                return False
            if possible[s / 2 - n]:
                return True
            for v in xrange(s / 2 - 1, n - 1, -1):
                possible[v] |= possible[v - n]
        return False
