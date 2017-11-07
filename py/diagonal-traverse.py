class Solution(object):
    def findDiagonalOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        M = len(matrix)
        if M == 0:
            return []
        N = len(matrix[0])
        ans = []
        for i in xrange(M + N - 1):
            if i % 2 == 0:
                for x in xrange(min(i, M - 1), max(i - N + 1, 0) - 1, -1):
                    ans.append(matrix[x][i - x])
            else:
                for x in xrange(max(i - N + 1, 0), min(i, M - 1) + 1):
                    ans.append(matrix[x][i - x])
        return ans
