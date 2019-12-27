package leetcode

func numberOfLines(widths []int, S string) []int {
	if len(S) == 0 {
		return []int{0, 0}
	}
	lines := 0
	accu := 0
	for _, c := range S {
		if accu+widths[c-'a'] > 100 {
			lines++
			accu = 0
		}
		accu += widths[c-'a']
	}
	return []int{lines + 1, accu}
}
