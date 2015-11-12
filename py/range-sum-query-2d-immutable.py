class NumMatrix(object):
    def __init__(self, matrix):
        """
        initialize your data structure here.
        :type matrix: List[List[int]]
        """
        if len(matrix) and len(matrix[0]):
            self.subsum = [([0] * (len(matrix[0]) + 1)) for _ in xrange(len(matrix) + 1)]
            for i in xrange(len(matrix)):
                for j in xrange(len(matrix[0])):
                    self.subsum[i + 1][j + 1] = self.subsum[i + 1][j] + matrix[i][j]
            for i in xrange(len(matrix)):
                for j in xrange(len(matrix[0])):
                    self.subsum[i + 1][j + 1] += self.subsum[i][j + 1]


    def sumRegion(self, row1, col1, row2, col2):
        """
        sum of elements matrix[(row1,col1)..(row2,col2)], inclusive.
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        return self.subsum[row2 + 1][col2 + 1] - self.subsum[row2 + 1][col1] - self.subsum[row1][col2 + 1] + self.subsum[row1][col1]



# Your NumMatrix object will be instantiated and called as such:
# numMatrix = NumMatrix(matrix)
# numMatrix.sumRegion(0, 1, 2, 3)
# numMatrix.sumRegion(1, 2, 3, 4)
