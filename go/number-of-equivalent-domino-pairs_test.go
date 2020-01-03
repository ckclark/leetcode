package leetcode

import "testing"

func TestNumEquivDominoPairs(t *testing.T) {
	if numEquivDominoPairs([][]int{
		[]int{1, 2},
		[]int{2, 1},
		[]int{3, 4},
		[]int{5, 6},
	}) != 1 {
		t.Fatal()
	}
}
