package leetcode

import "testing"

func TestNumMagicSquaresInside(t *testing.T) {
	if numMagicSquaresInside([][]int{
		[]int{4, 3, 8, 4},
		[]int{9, 5, 1, 9},
		[]int{2, 7, 6, 2},
	}) != 1 {
		t.Fatal()
	}
}
