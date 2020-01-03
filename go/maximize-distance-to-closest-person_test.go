package leetcode

import "testing"

func TestMaxDistToClosest(t *testing.T) {
	if maxDistToClosest([]int{1, 0, 0, 0, 1, 0, 1}) != 2 {
		t.Fatal()
	}
	if maxDistToClosest([]int{1, 0, 0, 0}) != 3 {
		t.Fatal()
	}
	if maxDistToClosest([]int{1, 0, 0, 1}) != 1 {
		t.Fatal()
	}
}
