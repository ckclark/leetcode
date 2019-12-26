package leetcode

func countCharacters(words []string, chars string) int {
	counter := make(map[rune]int)
	for _, c := range chars {
		counter[c] += 1
	}
	ans := 0
	for _, w := range words {
		ans += len(w)
		c2 := make(map[rune]int)
		for _, c := range w {
			c2[c] += 1
			if c2[c] > counter[c] {
				ans -= len(w)
				break
			}
		}
	}
	return ans
}
