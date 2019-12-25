package leetcode

func abs(v int) int {
	if v < 0 {
		return -v
	}
	return v
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func minTimeToVisitAllPoints(points [][]int) int {
	var prev *[]int
	ans := 0
	for _, p := range points {
		if prev != nil {
			ans += max(abs((*prev)[0]-p[0]), abs((*prev)[1]-p[1]))
		}
		prev = &[]int{p[0], p[1]}
	}
	return ans
}
