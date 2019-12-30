package leetcode

func tribonacci(n int) int {
	a0, a1, a2 := 0, 1, 1
	for ; n > 0; n-- {
		a0, a1, a2 = a1, a2, a0+a1+a2
	}
	return a0
}
