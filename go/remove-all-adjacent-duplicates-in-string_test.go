package leetcode

import "testing"

func TestRemoveDuplicates(t *testing.T) {
	if removeDuplicates("abbaca") != "ca" {
		t.Fatal()
	}
}
