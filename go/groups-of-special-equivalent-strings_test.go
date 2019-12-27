package leetcode

import "testing"

func TestNumSpecialEquivGroups(t *testing.T) {
	if numSpecialEquivGroups([]string{"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"}) != 3 {
		t.Fatal()
	}
	if numSpecialEquivGroups([]string{"abc", "acb", "bac", "bca", "cab", "cba"}) != 3 {
		t.Fatal()
	}
}
