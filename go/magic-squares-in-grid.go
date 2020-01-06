package leetcode

func valid(grid [][]int, x, y int) bool {
	visit := make([]bool, 9)
	for i := x; i < x+3; i++ {
		for j := y; j < y+3; j++ {
			if grid[i][j] > 9 || grid[i][j] < 1 {
				return false
			}
			if visit[grid[i][j]-1] {
				return false
			}
			visit[grid[i][j]-1] = true
		}
	}
	for i := 0; i < 3; i++ {
		if grid[x+i][y+0]+grid[x+i][y+1]+grid[x+i][y+2] != 15 {
			return false
		}
		if grid[x+0][y+i]+grid[x+1][y+i]+grid[x+2][y+i] != 15 {
			return false
		}
	}
	if grid[x+0][y+0]+grid[x+1][y+1]+grid[x+2][y+2] != 15 {
		return false
	}
	if grid[x+0][y+2]+grid[x+1][y+1]+grid[x+2][y+0] != 15 {
		return false
	}
	return true
}

func numMagicSquaresInside(grid [][]int) int {
	h, w := len(grid), len(grid[0])
	ans := 0
	for i := 0; i < h-2; i++ {
		for j := 0; j < w-2; j++ {
			if valid(grid, i, j) {
				ans++
			}
		}
	}
	return ans
}
