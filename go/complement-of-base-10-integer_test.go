package leetcode

import "testing"

func TestBitwiseComplement(t *testing.T) {
	if bitwiseComplement(5) != 2 {
		t.Fatal()
	}
	if bitwiseComplement(7) != 0 {
		t.Fatal()
	}
	if bitwiseComplement(10) != 5 {
		t.Fatal()
	}
}
