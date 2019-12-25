package leetcode

import "testing"

func TestBalancedStringSplit(t *testing.T) {
	if balancedStringSplit("RLRRLLRLRL") != 4 {
		t.Fatal()
	}
}
