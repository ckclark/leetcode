package leetcode

import "testing"

func TestDefangIPaddr(t *testing.T) {
	if defangIPaddr("1.1.1.1") != "1[.]1[.]1[.]1" {
		t.Fatal()
	}

	if defangIPaddr("255.100.50.0") != "255[.]100[.]50[.]0" {
		t.Fatal()
	}
}
