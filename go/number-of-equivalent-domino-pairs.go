package leetcode

type Key struct {
	x, y int
}

func numEquivDominoPairs(dominoes [][]int) int {
	counter := make(map[Key]int)
	for _, d := range dominoes {
		if d[0] > d[1] {
			counter[Key{d[1], d[0]}]++
		} else {
			counter[Key{d[0], d[1]}]++
		}
	}
	ans := 0
	for _, v := range counter {
		ans += v * (v - 1) / 2
	}
	return ans
}
