package leetcode

import "sort"

func freq(w string) int {
	lowest := 'z'
	m := make(map[rune]int)
	for _, c := range w {
		m[c]++
		if c < lowest {
			lowest = c
		}
	}
	return m[lowest]
}

func numSmallerByFrequency(queries []string, words []string) []int {
	fwords := make([]int, len(words))
	for idx, w := range words {
		fwords[idx] = freq(w)
	}
	sort.Ints(fwords)

	ans := make([]int, len(queries))
	for idx, w := range queries {
		f := freq(w)
		L, U := -1, len(words)
		for L+1 < U {
			m := (L + U) / 2
			if fwords[m] > f {
				U = m
			} else {
				L = m
			}
		}
		ans[idx] = len(words) - U
	}
	return ans
}
