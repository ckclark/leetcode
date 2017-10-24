from collections import Counter
import heapq
class Neg():
    def __init__(self, x):
        self.x = x

    def __cmp__(self, other):
        return -cmp(self.x, other.x)

class Solution(object):
    def topKFrequent_nlogk(self, words, k):
        """
        :type words: List[str]
        :type k: int
        :rtype: List[str]
        """
        c = Counter(words)
        ary = [Neg((-cnt, w)) for w, cnt in c.iteritems()]
        heap = ary[:k]
        heapq.heapify(heap)
        for i in xrange(k, len(ary)):
            heapq.heappush(heap, ary[i])
            heapq.heappop(heap)
        heap.sort(key=lambda x:(x.x[0], x.x[1]))
        return [x.x[1] for x in heap]


    def topKFrequent_klogn(self, words, k):
        """
        :type words: List[str]
        :type k: int
        :rtype: List[str]
        """
        c = Counter(words)
        ary = [(-cnt, w) for w, cnt in c.iteritems()]
        return [x[1] for x in heapq.nsmallest(k, ary)]

    topKFrequent = topKFrequent_nlogk
