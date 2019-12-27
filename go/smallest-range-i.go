package leetcode

func smallestRangeI(A []int, K int) int {
	m, M := A[0], A[0]
	for _, v := range A {
		if m > v {
			m = v
		}
		if M < v {
			M = v
		}
	}
	ans := M - m - 2*K
	if ans < 0 {
		ans = 0
	}
	return ans
}
