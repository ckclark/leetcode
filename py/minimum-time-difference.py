class Solution(object):
    def findMinDifference(self, timePoints):
        """
        :type timePoints: List[str]
        :rtype: int
        """
        timePoints = map(lambda x:int(x.split(':')[0]) * 60 + int(x.split(':')[1]), timePoints)
        MINUTES_IN_A_DAY = 24 * 60
        timePoints.sort()
        m = timePoints[0] + MINUTES_IN_A_DAY - timePoints[-1]
        it1, it2 = iter(timePoints), iter(timePoints)
        it2.next()
        return min(m, min(t2 - t1 for (t1, t2) in zip(it1, it2)))
