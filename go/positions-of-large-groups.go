package leetcode

func largeGroupPositions(S string) [][]int {
	start := 0
	var prev rune
	ans := make([][]int, 0, len(S)/3)
	for i, c := range S {
		if c != prev {
			if i-start >= 3 {
				ans = append(ans, []int{start, i - 1})
			}
			start, prev = i, c
		}
	}
	if len(S)-start >= 3 {
		ans = append(ans, []int{start, len(S) - 1})
	}
	return ans
}
