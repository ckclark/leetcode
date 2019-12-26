package leetcode

func minDeletionSize(A []string) int {
	n := len(A)
	l := len(A[0])
	ans := 0
	for i := 0; i < l; i++ {
		for j := 1; j < n; j++ {
			if A[j][i] < A[j-1][i] {
				ans += 1
				break
			}
		}
	}
	return ans
}
