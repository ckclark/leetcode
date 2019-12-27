package leetcode

func shortestToChar(S string, C byte) []int {
	positions := make([]int, 0, len(S))
	for idx, c := range S {
		if c == rune(C) {
			positions = append(positions, idx)
		}
	}
	ans := make([]int, len(S))
	x := 0
	for i := 0; i < len(S); i++ {
		if x < len(positions) && i > positions[x] {
			x++
		}
		if x == 0 {
			ans[i] = positions[x] - i
		} else if x == len(positions) {
			ans[i] = i - positions[x-1]
		} else {
			a := positions[x] - i
			b := i - positions[x-1]
			if a > b {
				ans[i] = b
			} else {
				ans[i] = a
			}
		}
	}
	return ans
}
