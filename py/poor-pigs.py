from itertools import count
class Solution(object):
    def poorPigs(self, buckets, minutesToDie, minutesToTest):
        """
        :type buckets: int
        :type minutesToDie: int
        :type minutesToTest: int
        :rtype: int
        """
        t = minutesToTest / minutesToDie
        for pigs in count(0):
            if (t + 1) ** pigs >= buckets:
                return pigs
