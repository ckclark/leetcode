class Solution(object):
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        d = {1: 1, 2:2, 3: 3, 4: 4}
        d[1] = 1
        if n <= 3:
            return n - 1
        for i in xrange(5, n + 1):
            d[i] = max(d[a] * d[i - a] for a in xrange(1, i / 2 + 1))
        return d[n]
