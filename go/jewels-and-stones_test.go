package leetcode

import "testing"

func TestNumJewelsInStones(t *testing.T) {
	if numJewelsInStones("aA", "aAAbbbb") != 3 {
		t.Fatal()
	}
	if numJewelsInStones("z", "ZZ") != 0 {
		t.Fatal()
	}
}
