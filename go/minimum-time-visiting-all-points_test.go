package leetcode

import "testing"

func TestMinTimeToVisitAllPoints(t *testing.T) {
	if minTimeToVisitAllPoints([][]int{[]int{1, 1}, []int{3, 4}, []int{-1, 0}}) != 7 {
		t.Fatal()
	}
}
