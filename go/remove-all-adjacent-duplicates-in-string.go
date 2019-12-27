package leetcode

func removeDuplicates(S string) string {
	stack := make([]rune, len(S))
	size := 0
	for _, c := range S {
		if size > 0 && c == stack[size-1] {
			size--
		} else {
			stack[size] = c
			size++
		}
	}
	return string(stack[:size])
}
