package leetcode

import "strconv"

func freqAlphabets(s string) string {
	ls := len(s)
	out := make([]rune, 0, ls)
	p := ls - 1
	for p >= 0 {
		if s[p] == '#' {
			ch, _ := strconv.Atoi(s[p-2 : p])
			out = append(out, rune(ch-1+'a'))
			p -= 3
		} else {
			ch := s[p]
			out = append(out, rune(ch-'0'-1+'a'))
			p--
		}
	}
	lout := len(out)
	i, j := 0, lout-1
	for i < j {
		out[i], out[j] = out[j], out[i]
		i++
		j--
	}
	return string(out)
}
