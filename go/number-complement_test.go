package leetcode

import "testing"

func TestFindComplement(t *testing.T) {
	if findComplement(5) != 2 {
		t.Fatal()
	}
}
