from collections import Counter
class Solution(object):
    def findPairs(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        if k < 0:
            return 0
        if k == 0:
            counter = Counter(nums)
            return sum(c > 1 for n, c in counter.iteritems())
        else:
            s = set(nums)
            return sum(x + k in s for x in s)
