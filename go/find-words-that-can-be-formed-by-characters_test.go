package leetcode

import "testing"

func TestCountCharacters(t *testing.T) {
	if countCharacters([]string{"cat", "bt", "hat", "tree"}, "atach") != 6 {
		t.Fatal()
	}
	if countCharacters([]string{"hello", "world", "leetcode"}, "welldonehoneyr") != 10 {
		t.Fatal()
	}
}
