package leetcode

import "strings"

func uncommonFromSentences(A string, B string) []string {
	countA, countB := make(map[string]int), make(map[string]int)
	for _, s := range strings.Split(A, " ") {
		countA[s]++
	}
	for _, s := range strings.Split(B, " ") {
		countB[s]++
	}
	ans := []string{}
	for s, v := range countA {
		if _, ok := countB[s]; v == 1 && !ok {
			ans = append(ans, s)
		}
	}
	for s, v := range countB {
		if _, ok := countA[s]; v == 1 && !ok {
			ans = append(ans, s)
		}
	}
	return ans
}
