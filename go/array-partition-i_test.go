package leetcode

import "testing"

func TestArrayPairSum(t *testing.T) {
	if arrayPairSum([]int{1, 4, 3, 2}) != 4 {
		t.Fatal()
	}
}
