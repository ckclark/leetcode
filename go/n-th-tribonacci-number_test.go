package leetcode

import "testing"

func TestTribonaci(t *testing.T) {
	if tribonacci(4) != 4 {
		t.Fatal()
	}
	if tribonacci(25) != 1389537 {
		t.Fatal()
	}
}
