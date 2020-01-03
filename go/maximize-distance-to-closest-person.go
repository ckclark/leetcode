package leetcode

func maxDistToClosest(seats []int) int {
	start := 0
	ans := 0
	for i, v := range seats {
		if v == 1 {
			if start == 0 {
				ans = i - start
			} else if ans < (i-start+1)/2 {
				ans = (i - start + 1) / 2
			}
			start = i + 1
		}
	}
	if len(seats)-start > ans {
		ans = len(seats) - start
	}
	return ans
}
