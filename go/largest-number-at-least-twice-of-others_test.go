package leetcode

import "testing"

func TestDominantIndex(t *testing.T) {
	if dominantIndex([]int{3, 6, 1, 0}) != 1 {
		t.Fatal()
	}
	if dominantIndex([]int{1, 2, 3, 4}) != -1 {
		t.Fatal()
	}
}
