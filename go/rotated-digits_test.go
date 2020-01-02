package leetcode

import "testing"

func TestRotatedDigits(t *testing.T) {
	if rotatedDigits(10) != 4 {
		t.Fatal()
	}
}
