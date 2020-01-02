package leetcode

import "testing"

func TestGcdOfStrings(t *testing.T) {
	if gcdOfStrings("ABCABC", "ABC") != "ABC" {
		t.Fatal()
	}
	if gcdOfStrings("ABABAB", "ABAB") != "AB" {
		t.Fatal()
	}
	if gcdOfStrings("LEET", "CODE") != "" {
		t.Fatal()
	}
}
