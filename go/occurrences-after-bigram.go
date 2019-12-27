package leetcode

import "strings"

func findOcurrences(text string, first string, second string) []string {
	var prev1, prev2 string
	ans := []string{}
	for _, s := range strings.Split(text, " ") {
		if prev1 == first && prev2 == second {
			ans = append(ans, s)
		}
		prev1, prev2 = prev2, s
	}
	return ans
}
