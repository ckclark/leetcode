package leetcode

func dominantIndex(nums []int) int {
	tm, m, mi := 0, 0, 0
	for i, v := range nums {
		if m < v {
			tm = m * 2
			m = v
			mi = i
		} else if tm < v*2 {
			tm = v * 2
		}
	}
	if m >= tm {
		return mi
	} else {
		return -1
	}
}
