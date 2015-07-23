from collections import deque
class Solution:
    def insertMonotonicQueue(self, d, v):
        while d and d[-1][1] < v[1]:
            d.pop()
        d.append(v)

    # @param {integer[]} nums
    # @param {integer} k
    # @return {integer[]}
    def maxSlidingWindow(self, nums, k):
        if not nums:
            return []
        ans = []
        d = deque()
        for i in xrange(k):
            self.insertMonotonicQueue(d, (i, nums[i]))
        ans.append(d[0][1])
        for i in xrange(k, len(nums)):
            self.insertMonotonicQueue(d, (i, nums[i]))
            if d[0][0] == i - k:
                d.popleft()
            ans.append(d[0][1])
        return ans

