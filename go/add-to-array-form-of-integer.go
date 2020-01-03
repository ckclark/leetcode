package leetcode

func addToArrayForm(A []int, K int) []int {
	lA := len(A)
	for t := lA - 1; K > 0 && t >= 0; t-- {
		A[t] += K
		K = A[t] / 10
		A[t] %= 10
	}
	prepend := []int{}
	for K > 0 {
		prepend = append(prepend, K%10)
		K /= 10
	}
	if len(prepend) > 0 {
		i, j := 0, len(prepend)-1
		for i < j {
			prepend[i], prepend[j] = prepend[j], prepend[i]
			i++
			j--
		}
		A = append(prepend, A...)
	}
	return A
}
