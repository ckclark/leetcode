package leetcode

import "testing"

func TestCheckStraightLine(t *testing.T) {
	if checkStraightLine([][]int{
		[]int{1, 2},
		[]int{2, 3},
		[]int{3, 4},
		[]int{4, 5},
		[]int{5, 6},
		[]int{6, 7},
	}) != true {
		t.Fatal()
	}

	if checkStraightLine([][]int{
		[]int{1, 1},
		[]int{2, 2},
		[]int{3, 4},
		[]int{4, 5},
		[]int{5, 6},
		[]int{7, 7},
	}) != false {
		t.Fatal()
	}
}
