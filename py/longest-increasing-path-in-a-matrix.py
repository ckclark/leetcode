from collections import Counter
class Solution(object):
    def dfs(self, dp, matrix, x, y, w, h):
        v = matrix[x][y]
        if dp[x, y] == 0:
            dp[x, y] = 1 + max(
                0 if x == 0 or matrix[x - 1][y] <= v else self.dfs(dp, matrix, x - 1, y, w, h),
                0 if y == 0 or matrix[x][y - 1] <= v else self.dfs(dp, matrix, x, y - 1, w, h),
                0 if x == h - 1 or matrix[x + 1][y] <= v else self.dfs(dp, matrix, x + 1, y, w, h),
                0 if y == w - 1 or matrix[x][y + 1] <= v else self.dfs(dp, matrix, x, y + 1, w, h)
            )

        return dp[x, y]

    def longestIncreasingPath(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        if not matrix:
            return 0
        h = len(matrix)
        w = len(matrix[0])
        ans = 1
        starts = set(xrange(h * w))
        dp = Counter()
        for x, row in enumerate(matrix):
            for y, v in enumerate(row):
                ans = max(ans, self.dfs(dp, matrix, x, y, w, h))
        return ans
