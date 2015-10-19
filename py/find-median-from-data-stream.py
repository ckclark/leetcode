import heapq

class MedianFinder:
    def __init__(self):
        """
        Initialize your data structure here.
        """

        self.lowerheap = []
        self.upperheap = []

    def addNum(self, num):
        """
        Adds a num into the data structure.
        :type num: int
        :rtype: void
        """

        heapq.heappush(self.upperheap, num)
        heapq.heappush(self.lowerheap, -heapq.heappop(self.upperheap))
        if len(self.lowerheap) > len(self.upperheap):
            heapq.heappush(self.upperheap, -heapq.heappop(self.lowerheap))

    def findMedian(self):
        """
        Returns the median of current data stream
        :rtype: float
        """

        if len(self.upperheap) > len(self.lowerheap):
            return float(self.upperheap[0])
        elif len(self.upperheap) < len(self.lowerheap):
            return float(-self.lowerheap[0])
        else:
            return .5 * (self.upperheap[0] + -self.lowerheap[0])


# Your MedianFinder object will be instantiated and called as such:
# mf = MedianFinder()
# mf.addNum(1)
# mf.findMedian()
