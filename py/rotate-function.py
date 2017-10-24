class Solution(object):
    def maxRotateFunction(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        lA = len(A)
        if not lA:
            return 0
        subsum = 0
        F = 0
        for i in xrange(1, lA):
            subsum += A[-i]
            F += subsum
        subsum += A[0]
        m = F
        for i in xrange(1, lA):
            F += subsum
            F -= lA * A[-i]
            m = max(m, F)
        return m
