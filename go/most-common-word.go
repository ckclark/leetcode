package leetcode

import (
	"strings"
	"unicode"
)

func mostCommonWord(paragraph string, banned []string) string {
	bannedSet := make(map[string]struct{})
	for _, b := range banned {
		bannedSet[b] = struct{}{}
	}
	cnt := make(map[string]int)
	start := 0
	for i, c := range paragraph {
		if !unicode.IsLetter(c) {
			if i-start > 0 {
				cnt[strings.ToLower(paragraph[start:i])]++
			}
			start = i + 1
		}
	}
	if len(paragraph)-start > 0 {
		cnt[strings.ToLower(paragraph[start:])]++
	}
	m := 0
	ans := ""
	for k, v := range cnt {
		if _, ok := bannedSet[k]; !ok && v > m {
			ans = k
			m = v
		}
	}
	return ans
}
