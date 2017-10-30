class Solution(object):
    def findPoisonedDuration(self, timeSeries, duration):
        """
        :type timeSeries: List[int]
        :type duration: int
        :rtype: int
        """
        prev_end = None
        ans = 0
        for t in timeSeries:
            end = t + duration
            t = max(prev_end, t)
            ans += end - t
            prev_end = end
        return ans
