package leetcode

import "fmt"

func dayOfYear(date string) int {
	var y, m, d int
	fmt.Sscanf(date, "%d-%d-%d", &y, &m, &d)
	leap := false
	if y%400 == 0 {
		leap = true
	} else if y%100 != 0 && y%4 == 0 {
		leap = true
	}
	days := []int{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
	ans := 0
	if m >= 3 && leap {
		// leap year
		ans++
	}
	for i := 1; i < m; i++ {
		ans += days[i]
	}
	ans += d
	return ans
}
