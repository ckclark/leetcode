from collections import Counter
class Solution(object):
    def totalHammingDistance(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        c = Counter()
        for n in nums:
            for i in xrange(n.bit_length()):
                if n & (1 << i):
                    c[i] += 1
        ans = 0
        for k, v in c.iteritems():
            ans += v * (len(nums) - v)
        return ans

