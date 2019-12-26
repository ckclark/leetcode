package leetcode

import "math"

func projectionArea(grid [][]int) int {
	if len(grid) == 0 {
		return 0
	}
	ans := 0
	rmax := make([]int, len(grid))
	cmax := make([]int, len(grid[0]))

	for i, row := range grid {
		for j, v := range row {
			rmax[i] = int(math.Max(float64(v), float64(rmax[i])))
			cmax[j] = int(math.Max(float64(v), float64(cmax[j])))
			if v > 0 {
				ans++
			}
		}
	}
	for _, v := range rmax {
		ans += v
	}
	for _, v := range cmax {
		ans += v
	}
	return ans
}
