package leetcode

func isToeplitzMatrix(matrix [][]int) bool {
	R, C := len(matrix), len(matrix[0])
	for i := 1; i < R; i++ {
		for j := 1; j < C; j++ {
			if matrix[i][j] != matrix[i-1][j-1] {
				return false
			}
		}
	}
	return true
}
