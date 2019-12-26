package leetcode

import "testing"

func TestHammingDistance(t *testing.T) {
	if hammingDistance(1, 4) != 2 {
		t.Fatal()
	}
}
