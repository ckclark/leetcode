package leetcode

func surfaceArea(grid [][]int) int {
	r := len(grid)
	c := len(grid[0])

	ans := 0

	for i, row := range grid {
		for j, v := range row {
			if v > 0 {
				ans += 2
			}
			ans += 4 * v
			if i > 0 {
				if v < grid[i-1][j] {
					ans -= v
				} else {
					ans -= grid[i-1][j]
				}
			}

			if i < r-1 {
				if v < grid[i+1][j] {
					ans -= v
				} else {
					ans -= grid[i+1][j]
				}
			}

			if j > 0 {
				if v < grid[i][j-1] {
					ans -= v
				} else {
					ans -= grid[i][j-1]
				}
			}

			if j < c-1 {
				if v < grid[i][j+1] {
					ans -= v
				} else {
					ans -= grid[i][j+1]
				}
			}
		}
	}
	return ans
}
