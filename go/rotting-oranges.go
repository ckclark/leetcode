package leetcode

func orangesRotting(grid [][]int) int {
	h, w := len(grid), len(grid[0])
	qsize := h*w + 1
	q := make([][]int, qsize)
	head, tail := 0, 0
	rotten := 0
	for r, row := range grid {
		for c, v := range row {
			if v == 2 {
				q[head] = []int{r, c, 0}
				head = (head + 1) % qsize
			}
			if v > 0 {
				rotten++
			}
		}
	}

	ans := 0
	for head != tail {
		state := q[tail]
		tail = (tail + 1) % qsize
		r, c, t := state[0], state[1], state[2]
		ans = t
		rotten--
		if r > 0 && grid[r-1][c] == 1 {
			grid[r-1][c] = 2
			q[head] = []int{r - 1, c, t + 1}
			head = (head + 1) % qsize
		}
		if r < h-1 && grid[r+1][c] == 1 {
			grid[r+1][c] = 2
			q[head] = []int{r + 1, c, t + 1}
			head = (head + 1) % qsize
		}
		if c > 0 && grid[r][c-1] == 1 {
			grid[r][c-1] = 2
			q[head] = []int{r, c - 1, t + 1}
			head = (head + 1) % qsize
		}
		if c < w-1 && grid[r][c+1] == 1 {
			grid[r][c+1] = 2
			q[head] = []int{r, c + 1, t + 1}
			head = (head + 1) % qsize
		}
	}
	if rotten > 0 {
		return -1
	} else {
		return ans
	}
}
