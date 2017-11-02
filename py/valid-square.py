from operator import itemgetter
class Solution(object):
    def validSquare(self, p1, p2, p3, p4):
        """
        :type p1: List[int]
        :type p2: List[int]
        :type p3: List[int]
        :type p4: List[int]
        :rtype: bool
        """
        mid = [sum(map(itemgetter(0), [p1, p2, p3, p4])), sum(map(itemgetter(1), [p1, p2, p3, p4]))]
        v1 = [p1[0] * 4 - mid[0], p1[1] * 4 - mid[1]]
        for p in [p2, p3, p4]:
            if p1 == p:
                return False
            v = [p[0] * 4 - mid[0], p[1] * 4 - mid[1]]
            # perpendicular or parallel
            if v[0] * v1[0] + v[1] * v1[1] != 0 and v[0] * v1[1] != v[1] * v1[0]:
                return False
            # same length
            if v[0] * v[0] + v[1] * v[1] != v1[0] * v1[0] + v1[1] * v1[1]:
                return False
        return True
