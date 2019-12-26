package leetcode

func peakIndexInMountainArray(A []int) int {
	length := len(A)
	if A[0] > A[1] {
		return 0
	}
	if A[length-2] < A[length-1] {
		return length - 1
	}

	L, U := 0, len(A)-1
	for L+1 < U {
		mid := (L + U) / 2
		if A[mid-1] > A[mid] {
			U = mid
		} else {
			L = mid
		}
	}
	return L
}
