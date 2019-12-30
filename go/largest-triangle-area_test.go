package leetcode

import "testing"

func TestLargestTriangleArea(t *testing.T) {
	points := [][]int{
		[]int{0, 0},
		[]int{0, 1},
		[]int{1, 0},
		[]int{0, 2},
		[]int{2, 0},
	}
	if largestTriangleArea(points) != 2. {
		t.Fatal()
	}
}
