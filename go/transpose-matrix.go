package leetcode

func transpose(A [][]int) [][]int {
	R, C := len(A), len(A[0])
	ans := make([][]int, 0, C)
	for i := 0; i < C; i++ {
		ans = append(ans, make([]int, R))
		for j := 0; j < R; j++ {
			ans[i][j] = A[j][i]
		}
	}
	return ans
}
