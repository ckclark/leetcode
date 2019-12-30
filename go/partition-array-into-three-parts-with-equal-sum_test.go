package leetcode

import "testing"

func TestCanThreePartsEqualSum(t *testing.T) {
	if canThreePartsEqualSum([]int{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}) != true {
		t.Fatal()
	}
	if canThreePartsEqualSum([]int{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}) != false {
		t.Fatal()
	}
	if canThreePartsEqualSum([]int{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}) != true {
		t.Fatal()
	}
}
