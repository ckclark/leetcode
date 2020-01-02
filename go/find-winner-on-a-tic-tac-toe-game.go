package leetcode

func tictactoe(moves [][]int) string {
	grid := [][]rune{
		[]rune("..."),
		[]rune("..."),
		[]rune("..."),
	}
	for idx, move := range moves {
		x, y := move[0], move[1]
		if idx%2 == 0 {
			grid[x][y] = 'X'
			if grid[x][0] == grid[x][1] && grid[x][1] == grid[x][2] {
				return "A"
			}
			if grid[0][y] == grid[1][y] && grid[1][y] == grid[2][y] {
				return "A"
			}
			if grid[0][0] != '.' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] {
				return "A"
			}
			if grid[2][0] != '.' && grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2] {
				return "A"
			}
		} else {
			grid[x][y] = 'O'
			if grid[x][0] == grid[x][1] && grid[x][1] == grid[x][2] {
				return "B"
			}
			if grid[0][y] == grid[1][y] && grid[1][y] == grid[2][y] {
				return "B"
			}
			if grid[0][0] != '.' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] {
				return "B"
			}
			if grid[2][0] != '.' && grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2] {
				return "B"
			}
		}
	}
	if len(moves) == 9 {
		return "Draw"
	} else {
		return "Pending"
	}
}
