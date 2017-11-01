from operator import itemgetter
# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def findRightInterval(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[int]
        """
        sorted_itv = map(itemgetter(1, 2), sorted((x.start, i, x) for i, x in enumerate(intervals)))
        size = len(intervals)
        ans = []
        for itv in intervals:
            L, U = -1, size
            while L + 1 < U:
                mid = (L + U) / 2
                if sorted_itv[mid][1].start >= itv.end:
                    U = mid
                else:
                    L = mid
            if U == size:
                ans.append(-1)
            else:
                ans.append(sorted_itv[U][0])
        return ans
