package leetcode

import "testing"

func TestBinaryGap(t *testing.T) {
	if binaryGap(22) != 2 {
		t.Fatal()
	}

	if binaryGap(8) != 0 {
		t.Fatal()
	}

	if binaryGap(6) != 1 {
		t.Fatal()
	}
}
