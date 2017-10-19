from collections import Counter
class Solution(object):
    def numberOfBoomerangs(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        cs = [Counter() for _ in xrange(len(points))]
        for i1, p1 in enumerate(points):
            for i2 in range(i1 + 1, len(points)):
                p2 = points[i2]
                d = (p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2
                cs[i1][d] += 1
                cs[i2][d] += 1
        ans = 0
        for c in cs:
            for count in c.values():
                ans += count * (count - 1)
        return ans
