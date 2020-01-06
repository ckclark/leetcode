package leetcode

import "fmt"

func largestTimeFromDigits(A []int) string {
	cnt := make(map[int]int)
	for _, v := range A {
		cnt[v]++
	}
	for hr := 23; hr >= 0; hr-- {
		if cnt[hr/10] > 0 && cnt[hr%10] > 0 {
			if hr/10 == hr%10 && cnt[hr/10] == 1 {
				continue
			}
			cnt[hr/10]--
			cnt[hr%10]--
			a, b := -1, -1
			for v := range cnt {
				switch cnt[v] {
				case 2:
					a, b = v, v
				case 1:
					if a == -1 {
						a = v
					} else {
						b = v
					}
				}
			}
			if a < b {
				a, b = b, a
			}
			min := a*10 + b
			if min < 60 {
				return fmt.Sprintf("%02d:%02d", hr, min)
			} else {
				min = b*10 + a
				if min < 60 {
					return fmt.Sprintf("%02d:%02d", hr, min)
				}
			}
			cnt[hr/10]++
			cnt[hr%10]++
		}
	}
	return ""
}
