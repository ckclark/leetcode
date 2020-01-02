package leetcode

func less(s1, s2 string, rev map[rune]int) bool {
	l1, l2 := len(s1), len(s2)
	i, j := 0, 0
	for i < l1 && j < l2 {
		m1, m2 := rev[rune(s1[i])], rev[rune(s2[j])]
		if m1 > m2 {
			return false
		} else if m1 < m2 {
			return true
		}
		i++
		j++
	}
	return i == l1
}

func isAlienSorted(words []string, order string) bool {
	rev := make(map[rune]int)
	for i, c := range order {
		rev[c] = i
	}
	l := len(words)
	for i := 1; i < l; i++ {
		if !less(words[i-1], words[i], rev) {
			return false
		}
	}
	return true
}
