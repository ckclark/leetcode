package leetcode

import "testing"

func TestMinDeletionSize(t *testing.T) {
	if minDeletionSize([]string{"cba", "daf", "ghi"}) != 1 {
		t.Fatal()
	}
	if minDeletionSize([]string{"a", "b"}) != 0 {
		t.Fatal()
	}
	if minDeletionSize([]string{"zyx", "wuv", "tsr"}) != 3 {
		t.Fatal()
	}
}
