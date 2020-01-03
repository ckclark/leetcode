package leetcode

func powerfulIntegers(x int, y int, bound int) []int {
	set := make(map[int]struct{})

	vx, vy := 1, 1
	for ; vx+1 <= bound; vx *= x {
		for vy = 1; vx+vy <= bound; vy *= y {
			set[vx+vy] = struct{}{}
			if y == 1 {
				break
			}
		}
		if x == 1 {
			break
		}
	}
	ans := make([]int, 0, len(set))
	for v := range set {
		ans = append(ans, v)
	}
	return ans
}
