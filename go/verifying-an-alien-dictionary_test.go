package leetcode

import "testing"

func TestIsAlienSorted(t *testing.T) {
	if isAlienSorted([]string{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz") != true {
		t.Fatal()
	}
	if isAlienSorted([]string{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz") != false {
		t.Fatal()
	}
}
