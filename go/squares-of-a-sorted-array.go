package leetcode

func sortedSquares(A []int) []int {
	ans := make([]int, len(A))
	i, j := 0, len(A)-1
	p := len(A) - 1
	for p >= 0 {
		i2, j2 := A[i]*A[i], A[j]*A[j]
		if i2 > j2 {
			ans[p] = i2
			i++
		} else {
			ans[p] = j2
			j--
		}
		p--
	}
	return ans
}
