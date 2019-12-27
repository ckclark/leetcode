package leetcode

import "testing"

func TestLastStoneWeight(t *testing.T) {
	if lastStoneWeight([]int{2, 7, 1, 4, 8, 1}) != 1 {
		t.Fatal()
	}
	if lastStoneWeight([]int{1, 3}) != 2 {
		t.Fatal()
	}
	if lastStoneWeight([]int{2, 2}) != 0 {
		t.Fatal()
	}
}
