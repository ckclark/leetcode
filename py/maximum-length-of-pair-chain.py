class Solution(object):
    def findLongestChain(self, pairs):
        """
        :type pairs: List[List[int]]
        :rtype: int
        """
        pairs.sort()
        LIS = []
        for p in pairs:
            L, U = -1, len(LIS)
            while L + 1 < U:
                mid = (L + U) / 2
                if LIS[mid] < p[0]:
                    L = mid
                else:
                    U = mid
            if len(LIS) == U:
                LIS.append(p[1])
            else:
                LIS[L + 1] = min(LIS[L + 1], p[1])
        return len(LIS)
