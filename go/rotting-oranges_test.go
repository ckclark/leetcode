package leetcode

import "testing"

func TestOrangesRotting(t *testing.T) {
	if orangesRotting([][]int{
		[]int{2, 1, 1},
		[]int{1, 1, 0},
		[]int{0, 1, 1},
	}) != 4 {
		t.Fatal()
	}
	if orangesRotting([][]int{
		[]int{2, 1, 1},
		[]int{0, 1, 1},
		[]int{1, 0, 1},
	}) != -1 {
		t.Fatal()
	}
	if orangesRotting([][]int{
		[]int{0, 2},
	}) != 0 {
		t.Fatal()
	}
}
