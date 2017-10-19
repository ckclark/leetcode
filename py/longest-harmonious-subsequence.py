from collections import Counter
class Solution(object):
    def findLHS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        c = Counter(nums)
        m = 0
        for k in c:
            if k + 1 in c:
                m = max(m, c[k] + c[k + 1])
        return m
