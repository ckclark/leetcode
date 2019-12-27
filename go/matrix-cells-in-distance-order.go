package leetcode

func allCellsDistOrder(R int, C int, r0 int, c0 int) [][]int {
	ans := make([][]int, 0, R*C)
	ans = append(ans, []int{r0, c0})
	for d := 0; d < R+C-1; d++ {
		for i := 0; i < d; i++ {
			x, y := r0+i, c0+(d-i)
			if 0 <= x && x < R && 0 <= y && y < C {
				ans = append(ans, []int{x, y})
			}
		}
		for i := 0; i < d; i++ {
			x, y := r0+(d-i), c0-i
			if 0 <= x && x < R && 0 <= y && y < C {
				ans = append(ans, []int{x, y})
			}
		}
		for i := 0; i < d; i++ {
			x, y := r0-i, c0-(d-i)
			if 0 <= x && x < R && 0 <= y && y < C {
				ans = append(ans, []int{x, y})
			}
		}
		for i := 0; i < d; i++ {
			x, y := r0-(d-i), c0+i
			if 0 <= x && x < R && 0 <= y && y < C {
				ans = append(ans, []int{x, y})
			}
		}
	}
	return ans
}
