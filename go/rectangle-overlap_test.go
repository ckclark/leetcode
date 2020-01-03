package leetcode

import "testing"

func TestIsRectangleOverlap(t *testing.T) {
	if isRectangleOverlap([]int{0, 0, 2, 2}, []int{1, 1, 3, 3}) != true {
		t.Fatal()
	}
	if isRectangleOverlap([]int{0, 0, 1, 1}, []int{1, 0, 2, 1}) != false {
		t.Fatal()
	}
}
