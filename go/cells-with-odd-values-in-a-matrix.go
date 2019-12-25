package leetcode

func oddCells(n int, m int, indices [][]int) int {
	rows := make([]int, n)
	cols := make([]int, m)
	nrow, ncol := 0, 0
	for _, idx := range indices {
		rows[idx[0]] ^= 1
		if rows[idx[0]] == 1 {
			nrow++
		} else {
			nrow--
		}
		cols[idx[1]] ^= 1
		if cols[idx[1]] == 1 {
			ncol++
		} else {
			ncol--
		}
	}
	return nrow*m + ncol*n - nrow*ncol*2
}
