package leetcode

func sortArrayByParityII(A []int) []int {
	l := len(A)
	i, j := 0, 1
	for i < l && j < l {
		if A[i]&1 == 0 {
			i += 2
		} else if A[j]&1 == 1 {
			j += 2
		} else {
			A[i], A[j] = A[j], A[i]
			i += 2
			j += 2
		}
	}
	return A
}
