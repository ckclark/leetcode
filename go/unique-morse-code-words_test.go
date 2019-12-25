package leetcode

import "testing"

func TestUniqueMorseRepresentations(t *testing.T) {
	if uniqueMorseRepresentations([]string{"gin", "zen", "gig", "msg"}) != 2 {
		t.Fatal()
	}
}
