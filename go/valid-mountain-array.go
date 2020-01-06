package leetcode

func validMountainArray(A []int) bool {
	n := len(A)
	left, right := 0, n-1
	for i := 0; i < n-1 && A[i+1] > A[i]; i++ {
		left = i + 1
	}
	for i := n - 1; i > 0 && A[i] < A[i-1]; i-- {
		right = i - 1
	}
	return left != 0 && right != n-1 && left == right
}
