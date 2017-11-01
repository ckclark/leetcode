from collections import Counter
class Solution(object):
    def findTargetSumWays(self, nums, S):
        """
        :type nums: List[int]
        :type S: int
        :rtype: int
        """
        c = Counter()
        c[0] = 1
        for n in nums:
            nc = Counter()
            for k, v in c.iteritems():
                nc[k + n] += v
                nc[k - n] += v
            c = nc
        return c[S]

