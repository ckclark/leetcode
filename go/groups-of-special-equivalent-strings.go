package leetcode

import "sort"

type SortRunes []rune

func (s SortRunes) Less(i, j int) bool {
	return s[i] < s[j]
}

func (s SortRunes) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}

func (s SortRunes) Len() int {
	return len(s)
}

func numSpecialEquivGroups(A []string) int {
	m := make(map[string]struct{})
	for _, s := range A {
		odd, even := make([]rune, 0, len(A)/2), make([]rune, 0, len(A)/2)
		for idx, c := range s {
			if idx%2 == 1 {
				odd = append(odd, c)
			} else {
				even = append(even, c)
			}
		}
		sort.Sort(SortRunes(odd))
		sort.Sort(SortRunes(even))
		m[string(odd)+string(even)] = struct{}{}
	}
	return len(m)
}
