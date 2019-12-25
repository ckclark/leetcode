package leetcode

import "testing"

func TestOddCells(t *testing.T) {
	if oddCells(2, 3, [][]int{[]int{0, 1}, []int{1, 1}}) != 6 {
		t.Fatal()
	}
	if oddCells(2, 2, [][]int{[]int{1, 1}, []int{0, 0}}) != 0 {
		t.Fatal()
	}
}
