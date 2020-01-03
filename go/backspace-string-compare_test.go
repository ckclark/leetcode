package leetcode

import "testing"

func TestBackspaceCompare(t *testing.T) {
	if backspaceCompare("ab#c", "ad#c") != true {
		t.Fatal()
	}
	if backspaceCompare("ab##", "c#d#") != true {
		t.Fatal()
	}
	if backspaceCompare("a##c", "#a#c") != true {
		t.Fatal()
	}
	if backspaceCompare("a#c", "b") != false {
		t.Fatal()
	}
	if backspaceCompare("bbbextm", "bbb#extm") != false {
		t.Fatal()
	}
	if backspaceCompare("nzp#o#g", "b#nzp#o#g") != true {
		t.Fatal()
	}
}
