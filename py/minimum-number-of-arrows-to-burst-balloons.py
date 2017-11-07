from operator import itemgetter
class Solution(object):
    def findMinArrowShots(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        points.sort(key=itemgetter(1))
        end = None
        ans = 0
        for p in points:
            if end is None or end < p[0]:
                end = p[1]
                ans += 1
        return ans
