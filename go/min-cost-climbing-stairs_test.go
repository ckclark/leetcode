package leetcode

import "testing"

func TestMinCostClimbingStairs(t *testing.T) {
	if minCostClimbingStairs([]int{10, 15, 20}) != 15 {
		t.Fatal()
	}
	if minCostClimbingStairs([]int{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}) != 6 {
		t.Fatal()
	}
}
