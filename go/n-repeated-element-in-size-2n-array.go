package leetcode

func repeatedNTimes(A []int) int {
	l := len(A)
	if A[0] == A[2] {
		return A[0]
	}
	if A[1] == A[3] {
		return A[1]
	}
	for i := 0; i < l-1; i++ {
		if A[i] == A[i+1] {
			return A[i]
		}
	}
	return A[0]
}
