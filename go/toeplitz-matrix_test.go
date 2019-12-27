package leetcode

import "testing"

func TestIsToeplitzMatrix(t *testing.T) {
	q1 := [][]int{
		[]int{1, 2, 3, 4},
		[]int{5, 1, 2, 3},
		[]int{9, 5, 1, 2},
	}
	if isToeplitzMatrix(q1) != true {
		t.Fatal()
	}
	q2 := [][]int{
		[]int{1, 2},
		[]int{2, 2},
	}
	if isToeplitzMatrix(q2) != false {
		t.Fatal()
	}
}
