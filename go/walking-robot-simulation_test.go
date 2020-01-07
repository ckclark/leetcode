package leetcode

import "testing"

func TestRobotSim(t *testing.T) {
	if robotSim([]int{4, -1, 3}, [][]int{}) != 25 {
		t.Fatal()
	}
	if robotSim([]int{4, -1, 4, -2, 4}, [][]int{
		[]int{2, 4},
	}) != 65 {
		t.Fatal()
	}
	if robotSim([]int{2, 2, 5, -1, -1}, [][]int{
		[]int{-3, 5},
		[]int{-2, 5},
		[]int{3, 2},
		[]int{5, 0},
		[]int{-2, 0},
		[]int{-1, 5},
		[]int{5, -3},
		[]int{0, 0},
		[]int{-4, 4},
		[]int{-3, 4},
	}) != 81 {
		t.Fatal()
	}
}
