package leetcode

func balancedStringSplit(s string) int {
	r, l := 0, 0
	ans := 0
	for _, c := range s {
		if c == 'R' {
			r += 1
		} else if c == 'L' {
			l += 1
		}
		if r == l {
			ans += 1
		}
	}
	return ans
}
