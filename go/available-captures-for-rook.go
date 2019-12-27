package leetcode

func numRookCaptures(board [][]byte) int {
	var x, y int
	for i := 0; i < 8; i++ {
		var j int
		for j = 0; j < 8; j++ {
			if board[i][j] == 'R' {
				x, y = i, j
				break
			}
		}
		if j < 8 {
			break
		}
	}
	ans := 0
	for i := x - 1; i >= 0; i-- {
		if board[i][y] == 'p' {
			ans++
			break
		} else if board[i][y] == 'B' {
			break
		}
	}
	for i := x + 1; i < 8; i++ {
		if board[i][y] == 'p' {
			ans++
			break
		} else if board[i][y] == 'B' {
			break
		}
	}
	for i := y - 1; i >= 0; i-- {
		if board[x][i] == 'p' {
			ans++
			break
		} else if board[x][i] == 'B' {
			break
		}
	}
	for i := y + 1; i < 8; i++ {
		if board[x][i] == 'p' {
			ans++
			break
		} else if board[x][i] == 'B' {
			break
		}
	}
	return ans
}
