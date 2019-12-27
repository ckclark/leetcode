package leetcode

import "testing"

func TestMinCostToMoveChips(t *testing.T) {
	if minCostToMoveChips([]int{1, 2, 3}) != 1 {
		t.Fatal()
	}
	if minCostToMoveChips([]int{2, 2, 2, 3, 3}) != 2 {
		t.Fatal()
	}
}
