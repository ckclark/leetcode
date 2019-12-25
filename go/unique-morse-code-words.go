package leetcode

import "strings"

func uniqueMorseRepresentations(words []string) int {
	morse := []string{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."}
	set := make(map[string]struct{})
	for _, w := range words {
		b := strings.Builder{}
		for _, c := range w {
			b.WriteString(morse[c-'a'])
		}
		set[b.String()] = struct{}{}
	}
	return len(set)
}
