package leetcode

func shiftGrid(grid [][]int, k int) [][]int {
	out := make([][]int, 0, len(grid))
	rows := len(grid)
	cols := len(grid[0])
	shift_c := k % cols
	shift_r := (k / cols) % rows
	for i := 0; i < rows; i++ {
		r := make([]int, 0, cols)
		r = append(r, grid[(i+rows-shift_r-1)%rows][cols-shift_c:]...)
		r = append(r, grid[(i+rows-shift_r)%rows][:cols-shift_c]...)
		out = append(out, r)
	}
	return out
}
