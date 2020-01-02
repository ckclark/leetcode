package leetcode

import "testing"

func TestSearch(t *testing.T) {
	if search([]int{-1, 0, 3, 5, 9, 12}, 9) != 4 {
		t.Fatal()
	}
	if search([]int{-1, 0, 3, 5, 9, 12}, 2) != -1 {
		t.Fatal()
	}
}
