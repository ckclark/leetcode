package leetcode

import "testing"

func TestSmallestRangeI(t *testing.T) {
	if smallestRangeI([]int{1}, 0) != 0 {
		t.Fatal()
	}
	if smallestRangeI([]int{0, 10}, 2) != 6 {
		t.Fatal()
	}
	if smallestRangeI([]int{1, 3, 6}, 3) != 0 {
		t.Fatal()
	}
}
