import heapq
from collections import Counter

class Solution(object):
    def insertElement(self, value):
        if self.minHeapSize < self.maxHeapSize:
            heapq.heappush(self.maxHeap, -value)
            m = self.maxHeapPop()
            heapq.heappush(self.minHeap, m)
            self.minHeapSize += 1
        else:
            heapq.heappush(self.minHeap, value)
            m = self.minHeapPop()
            heapq.heappush(self.maxHeap, -m)
            self.maxHeapSize += 1

    def minHeapPop(self):
        while self.minRemoved[self.minHeap[0]] > 0:
            v = heapq.heappop(self.minHeap)
            self.minRemoved[v] -= 1
        return heapq.heappop(self.minHeap)

    def maxHeapPop(self):
        while self.maxRemoved[-self.maxHeap[0]] > 0:
            v = -heapq.heappop(self.maxHeap)
            self.maxRemoved[v] -= 1
        return -heapq.heappop(self.maxHeap)

    def minHeapTop(self):
        while self.minRemoved[self.minHeap[0]] > 0:
            v = heapq.heappop(self.minHeap)
            self.minRemoved[v] -= 1
        return self.minHeap[0]

    def maxHeapTop(self):
        while self.maxRemoved[-self.maxHeap[0]] > 0:
            v = -heapq.heappop(self.maxHeap)
            self.maxRemoved[v] -= 1
        return -self.maxHeap[0]

    def windowMedian(self):
        if self.maxHeapSize < self.minHeapSize:
            return float(self.minHeapTop())
        elif self.maxHeapSize > self.minHeapSize:
            return float(self.maxHeapTop())
        else:
            return (self.minHeapTop() + self.maxHeapTop()) / 2.

    def removeFromHeaps(self, value):
        if self.minHeapSize > 0 and self.minHeapTop() <= value:
            self.minRemoved[value] += 1
            self.minHeapSize -= 1
        else:
            self.maxRemoved[value] += 1
            self.maxHeapSize -= 1


    def medianSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[float]
        """
        self.minHeap, self.maxHeap = [], []
        self.minHeapSize, self.maxHeapSize = 0, 0
        self.minRemoved = Counter()
        self.maxRemoved = Counter()
        slidingWindow = []
        for i in xrange(k - 1):
            self.insertElement(nums[i])

        for i in xrange(k - 1, len(nums)):
            self.insertElement(nums[i])
            slidingWindow.append(self.windowMedian())
            self.removeFromHeaps(nums[i - k + 1])
        return slidingWindow

