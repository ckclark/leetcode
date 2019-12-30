package leetcode

func findLUSlength(a string, b string) int {
	la, lb := len(a), len(b)
	if la > lb {
		return la
	} else if la < lb {
		return lb
	}
	if a != b {
		return la
	}
	return -1
}
