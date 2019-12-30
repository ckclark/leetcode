package leetcode

import "testing"

func TestFindSpecialInteger(t *testing.T) {
	if findSpecialInteger([]int{1, 2, 2, 6, 6, 6, 6, 7, 10}) != 6 {
		t.Fatal()
	}
}
