package leetcode

import "sort"

func largestPerimeter(A []int) int {
	sort.Ints(A)
	l := len(A)
	for i := l - 1; i >= 2; i-- {
		if A[i-1]+A[i-2] > A[i] {
			return A[i-1] + A[i-2] + A[i]
		}
	}
	return 0
}
