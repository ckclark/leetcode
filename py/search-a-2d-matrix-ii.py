import bisect
class Solution:
    # @param {integer[][]} matrix
    # @param {integer} target
    # @return {boolean}
    def searchMatrix(self, matrix, target):
        L, R, U, D = 0, len(matrix[0]), 0, len(matrix)
        return self.searchMatrixInternal(matrix, L, R, U, D, target)

    def searchMatrixInternal(self, matrix, L, R, U, D, target):
        if L == R or U == D:
            return False
        mid = U + (D - U) / 2
        idx = bisect.bisect_left(matrix[mid], target, L, R)
        if idx < R:
            if matrix[mid][idx] == target:
                return True
        return self.searchMatrixInternal(matrix, L, idx, mid + 1, D, target) or self.searchMatrixInternal(matrix, idx, R, U, mid, target)

def main():
    matrix = [
            [5],
            [6],
    ]
    print Solution().searchMatrix(matrix, 5)

if __name__ == '__main__':
    main()
