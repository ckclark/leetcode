package leetcode

func sumZero(n int) []int {
	if n == 1 {
		return []int{0}
	}
	ans := make([]int, 0, n)
	final := 0
	for i := 1; i < n; i++ {
		ans = append(ans, i)
		final -= i
	}
	ans = append(ans, final)
	return ans
}
