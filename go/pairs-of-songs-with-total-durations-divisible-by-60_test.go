package leetcode

import "testing"

func TestNumPairsDivisibleBy60(t *testing.T) {
	if numPairsDivisibleBy60([]int{30, 20, 150, 100, 40}) != 3 {
		t.Fatal()
	}
}
