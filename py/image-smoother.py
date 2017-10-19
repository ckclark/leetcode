class Solution(object):
    def imageSmoother(self, M):
        """
        :type M: List[List[int]]
        :rtype: List[List[int]]
        """
        if not M or not M[0]:
            return M
        R = len(M)
        C = len(M[0])
        subsum = [[0] * (len(M[0]) + 3) for _ in xrange(len(M) + 3)]
        for r in xrange(2, R + 3):
            for c in xrange(2, C + 3):
                v = M[r - 2][c - 2] if r - 2 < R and c - 2 < C else 0
                subsum[r][c] = subsum[r][c - 1] + subsum[r - 1][c] - subsum[r - 1][c - 1] + v

        for r, row in enumerate(M):
            for c, v in enumerate(row):
                row[c] = (subsum[r + 3][c + 3] - subsum[r + 3][c] - subsum[r][c + 3] + subsum[r][c]) / (min(r + 2, 3, R - r + 1, R) * min(c + 2, 3, C - c + 1, C))
        return M
