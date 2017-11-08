from operator import attrgetter
# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def eraseOverlapIntervals(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        intervals.sort(key=attrgetter('end', 'start'))
        if not intervals:
            return 0
        end = None
        ans = 0
        for itv in intervals:
            if end is None:
                end = itv.end
            else:
                if itv.start < end:
                    ans += 1
                else:
                    end = itv.end
        return ans
