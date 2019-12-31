package leetcode

import "unicode"

func reverseOnlyLetters(S string) string {
	lS := len(S)
	outS := make([]rune, lS)
	head, tail := 0, lS-1
	for head <= tail {
		if !unicode.IsLetter(rune(S[head])) {
			outS[head] = rune(S[head])
			head++
		} else if !unicode.IsLetter(rune(S[tail])) {
			outS[tail] = rune(S[tail])
			tail--
		} else {
			outS[head], outS[tail] = rune(S[tail]), rune(S[head])
			head++
			tail--
		}
	}
	return string(outS)
}
