package leetcode

import "unicode"

func shortestCompletingWord(licensePlate string, words []string) string {
	pcounter := make(map[rune]int)
	used := 0
	for _, c := range licensePlate {
		if unicode.IsLetter(c) {
			c = unicode.ToLower(c)
			if _, ok := pcounter[c]; !ok {
				used++
			}
			pcounter[c]++
		}
	}
	l, ans := -1, ""
	for _, w := range words {
		rem := used
		tmp := make(map[rune]int)
		for _, c := range w {
			if unicode.IsLetter(c) {
				c = unicode.ToLower(c)
				tmp[c]++
				if tmp[c] == pcounter[c] {
					rem--
					if rem == 0 {
						if l == -1 || len(w) < l {
							l, ans = len(w), w
						}
					}
				}
			}
		}
	}
	return ans
}
