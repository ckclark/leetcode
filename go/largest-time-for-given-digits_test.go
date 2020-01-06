package leetcode

import "testing"

func TestLargestTimeFromDigits(t *testing.T) {
	if largestTimeFromDigits([]int{1, 2, 3, 4}) != "23:41" {
		t.Fatal()
	}
	if largestTimeFromDigits([]int{5, 5, 5, 5}) != "" {
		t.Fatal()
	}
	if largestTimeFromDigits([]int{0, 0, 1, 0}) != "10:00" {
		t.Fatal()
	}
	if largestTimeFromDigits([]int{1, 9, 6, 0}) != "19:06" {
		t.Fatal()
	}
}
