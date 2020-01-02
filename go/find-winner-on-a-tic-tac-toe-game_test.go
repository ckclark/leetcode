package leetcode

import "testing"

func TestTictactoe(t *testing.T) {
	if tictactoe([][]int{
		[]int{0, 0},
		[]int{2, 0},
		[]int{1, 1},
		[]int{2, 1},
		[]int{2, 2},
	}) != "A" {
		t.Fatal()
	}
	if tictactoe([][]int{
		[]int{0, 0},
		[]int{1, 1},
		[]int{0, 1},
		[]int{0, 2},
		[]int{1, 0},
		[]int{2, 0},
	}) != "B" {
		t.Fatal()
	}
	if tictactoe([][]int{
		[]int{0, 0},
		[]int{1, 1},
		[]int{2, 0},
		[]int{1, 0},
		[]int{1, 2},
		[]int{2, 1},
		[]int{0, 1},
		[]int{0, 2},
		[]int{2, 2},
	}) != "Draw" {
		t.Fatal()
	}
}
