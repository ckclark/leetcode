package leetcode

func diStringMatch(S string) []int {
	l := len(S)
	L, U := 0, 0
	ans := make([]int, l+1)
	for i, c := range S {
		if c == 'I' {
			U += 1
			ans[i+1] = U
		} else if c == 'D' {
			L -= 1
			ans[i+1] = L
		} else {
			panic("Impossible")
		}
	}
	for i := 0; i < l+1; i++ {
		ans[i] -= L
	}
	return ans
}
