package leetcode

import "testing"

func TestRotateString(t *testing.T) {
	if rotateString("abcde", "cdeab") != true {
		t.Fatal()
	}
	if rotateString("abcde", "abced") != false {
		t.Fatal()
	}
}
