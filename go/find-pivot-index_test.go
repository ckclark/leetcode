package leetcode

import "testing"

func TestPivotIndex(t *testing.T) {
	if pivotIndex([]int{1, 7, 3, 6, 5, 6}) != 3 {
		t.Fatal()
	}
	if pivotIndex([]int{1, 2, 3}) != -1 {
		t.Fatal()
	}
}
