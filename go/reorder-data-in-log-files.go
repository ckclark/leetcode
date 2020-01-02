package leetcode

import (
	"sort"
	"strings"
	"unicode"
)

type logs []string

func (l logs) Len() int {
	return len(l)
}

func (l logs) Less(i, j int) bool {
	sp1 := strings.Split(l[i], " ")
	sp2 := strings.Split(l[j], " ")
	if unicode.IsDigit(rune(sp1[1][0])) && unicode.IsDigit(rune(sp2[1][0])) {
		return false
	} else if unicode.IsDigit(rune(sp1[1][0])) {
		return false
	} else if unicode.IsDigit(rune(sp2[1][0])) {
		return true
	}
	l1, l2 := len(sp1), len(sp2)
	t1, t2 := 1, 1
	for t1 < l1 && t2 < l2 {
		if sp1[t1] < sp2[t2] {
			return true
		} else if sp1[t1] > sp2[t2] {
			return false
		}
		t1++
		t2++
	}
	return t1 == l1
}

func (l logs) Swap(i, j int) {
	l[i], l[j] = l[j], l[i]
}

func reorderLogFiles(logs_input []string) []string {
	l := logs(logs_input)
	sort.Stable(l)
	return []string(l)
}
