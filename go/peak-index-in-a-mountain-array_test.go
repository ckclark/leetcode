package leetcode

import "testing"

func TestPeakIndexInMountainArray(t *testing.T) {
	if peakIndexInMountainArray([]int{0, 1, 0}) != 1 {
		t.Fatal()
	}
	if peakIndexInMountainArray([]int{0, 2, 1, 0}) != 1 {
		t.Fatal()
	}
}
