package leetcode

import "testing"

func TestProjectionArea(t *testing.T) {
	if projectionArea([][]int{[]int{1, 0}, []int{0, 2}}) != 8 {
		t.Fatal()
	}
	if projectionArea([][]int{
		[]int{1, 1, 1},
		[]int{1, 0, 1},
		[]int{1, 1, 1},
	}) != 14 {
		t.Fatal()
	}

	if projectionArea([][]int{
		[]int{2, 2, 2},
		[]int{2, 1, 2},
		[]int{2, 2, 2},
	}) != 21 {
		t.Fatal()
	}
}
