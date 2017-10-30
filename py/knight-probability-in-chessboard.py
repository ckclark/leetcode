from collections import Counter
from math import log, exp
class Solution(object):
    def knightProbability(self, N, K, r, c):
        """
        :type N: int
        :type K: int
        :type r: int
        :type c: int
        :rtype: float
        """
        p = Counter()
        p[r, c] += 1
        ds = [(-1, -2), (-2, -1), (1, -2), (2, -1), (1, 2), (2, 1), (-1, 2), (-2, 1)]
        for i in xrange(K):
            np = Counter()
            for (px, py), prev_p in p.iteritems():
                for dx, dy in ds:
                    nx, ny = px + dx, py + dy
                    if 0 <= nx < N and 0 <= ny < N:
                        np[nx, ny] += prev_p
            p = np
        s = sum(p.values())
        return 0 if s == 0 else exp(log(sum(p.values())) - K * log(8))
