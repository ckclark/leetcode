package leetcode

import "testing"

func TestNumPrimeArrangements(t *testing.T) {
	if numPrimeArrangements(100) != 682289015 {
		t.Fatal()
	}
}
