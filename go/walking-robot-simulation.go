package leetcode

import (
	"sort"
)

type ByX [][]int
type ByY [][]int

func (ary ByX) Len() int {
	return len(ary)
}

func (ary ByY) Len() int {
	return len(ary)
}

func (ary ByX) Less(i, j int) bool {
	if ary[i][0] == ary[j][0] {
		return ary[i][1] < ary[j][1]
	}
	return ary[i][0] < ary[j][0]
}

func (ary ByY) Less(i, j int) bool {
	if ary[i][1] == ary[j][1] {
		return ary[i][0] < ary[j][0]
	}
	return ary[i][1] < ary[j][1]
}

func (ary ByX) Swap(i, j int) {
	ary[i], ary[j] = ary[j], ary[i]
}

func (ary ByY) Swap(i, j int) {
	ary[i], ary[j] = ary[j], ary[i]
}

func (ary ByX) findVertical(x, y int) (int, int) {
	L, U := -1, ary.Len()
	for L+1 < U {
		m := (L + U) / 2
		if ary[m][0] < x {
			L = m
		} else if ary[m][0] > x {
			U = m
		} else {
			if ary[m][1] < y {
				L = m
			} else {
				U = m
			}
		}
	}
	return L, U
}

func (ary ByY) findHorizontal(x, y int) (int, int) {
	L, U := -1, ary.Len()
	for L+1 < U {
		m := (L + U) / 2
		if ary[m][1] < y {
			L = m
		} else if ary[m][1] > y {
			U = m
		} else {
			if ary[m][0] < x {
				L = m
			} else {
				U = m
			}
		}
	}
	return L, U
}

func robotSim(commands []int, obstacles [][]int) int {
	const (
		NORTH = iota
		EAST
		SOUTH
		WEST
	)
	N := len(obstacles)
	byX := ByX(make([][]int, 0, N))
	byY := ByY(make([][]int, 0, N))
	for _, ob := range obstacles {
		if ob[0] != 0 || ob[1] != 0 {
			byX = append(byX, ob)
			byY = append(byY, ob)
		} else {
			N--
		}
	}
	sort.Sort(byX)
	sort.Sort(byY)
	dir := NORTH
	x, y := 0, 0
	ans := 0
	for _, cmd := range commands {
		switch cmd {
		case -1:
			dir = (dir + 1) % 4
		case -2:
			dir = (dir + 3) % 4
		default:
			switch dir {
			case NORTH, SOUTH:
				L, U := byX.findVertical(x, y)
				switch dir {
				case NORTH:
					y += cmd
					if U < N && byX[U][0] == x {
						if y >= byX[U][1] {
							y = byX[U][1] - 1
						}
					}
				case SOUTH:
					y -= cmd
					if L >= 0 && byX[L][0] == x {
						if y <= byX[L][1] {
							y = byX[L][1] + 1
						}
					}
				}
			case EAST, WEST:
				L, U := byY.findHorizontal(x, y)
				switch dir {
				case EAST:
					x += cmd
					if U < N && byY[U][1] == y {
						if x >= byY[U][0] {
							x = byY[U][0] - 1
						}
					}
				case WEST:
					x -= cmd
					if L >= 0 && byY[L][1] == y {
						if x <= byY[L][0] {
							x = byY[L][0] + 1
						}
					}
				}
			}
			if ans < x*x+y*y {
				ans = x*x + y*y
			}
		}
	}
	return ans
}
