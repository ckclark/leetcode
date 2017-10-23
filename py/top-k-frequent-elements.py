import heapq
from operator import itemgetter
from collections import Counter
class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        c = Counter(nums)
        return map(itemgetter(1), heapq.nlargest(k, [(cnt, n) for n, cnt in c.iteritems()]))
