package leetcode

import "testing"

func TestCountPrimeSetBits(t *testing.T) {
	if countPrimeSetBits(1, 1) != 0 {
		t.Fatal()
	}
	if countPrimeSetBits(6, 10) != 4 {
		t.Fatal()
	}
	if countPrimeSetBits(10, 15) != 5 {
		t.Fatal()
	}
	if countPrimeSetBits(842, 888) != 23 {
		t.Fatal()
	}
}
