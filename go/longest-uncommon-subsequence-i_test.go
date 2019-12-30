package leetcode

import "testing"

func TestFindLUSlength(t *testing.T) {
	if findLUSlength("aba", "cdc") != 3 {
		t.Fatal()
	}
}
