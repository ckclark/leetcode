package leetcode

func numMovesStones(a int, b int, c int) []int {
	if a > b {
		a, b = b, a
	}
	if b > c {
		b, c = c, b
	}
	if a > b {
		a, b = b, a
	}
	m := 2
	if a+1 == b && b+1 == c {
		m = 0
	} else if a+2 >= b || b+2 >= c {
		m = 1
	}
	return []int{m, c - a - 2}
}
