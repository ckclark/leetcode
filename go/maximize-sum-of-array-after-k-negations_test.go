package leetcode

import "testing"

func TestLargestSumAfterKNegations(t *testing.T) {
	if largestSumAfterKNegations([]int{4, 2, 3}, 1) != 5 {
		t.Fatal()
	}
	if largestSumAfterKNegations([]int{3, -1, 0, 2}, 3) != 6 {
		t.Fatal()
	}
	if largestSumAfterKNegations([]int{2, -3, -1, 5, -4}, 2) != 13 {
		t.Fatal()
	}
	if largestSumAfterKNegations([]int{-8, 3, -5, -3, -5, -2}, 6) != 22 {
		t.Fatal()
	}
}
