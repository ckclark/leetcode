class Solution(object):
    def findRadius(self, houses, heaters):
        """
        :type houses: List[int]
        :type heaters: List[int]
        :rtype: int
        """
        heaters.sort()
        lh = len(heaters)
        ans = 0
        for h in houses:
            L, U = -1, lh
            while L + 1 < U:
                mid = L + (U - L) / 2
                if heaters[mid] > h:
                    U = mid
                else:
                    L = mid
            m = None
            if L >= 0:
                d = abs(heaters[L] - h)
                if m is None:
                    m = d
                else:
                    m = min(m, d)
            if U < lh:
                d = abs(heaters[U] - h)
                if m is None:
                    m = d
                else:
                    m = min(m, d)
            ans = max(m, ans)
        return ans
