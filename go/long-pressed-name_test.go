package leetcode

import "testing"

func TestIsLongPressedName(t *testing.T) {
	if isLongPressedName("alex", "aaleex") != true {
		t.Fatal()
	}
	if isLongPressedName("saeed", "ssaaedd") != false {
		t.Fatal()
	}
	if isLongPressedName("leelee", "lleeelee") != true {
		t.Fatal()
	}
	if isLongPressedName("laiden", "laiden") != true {
		t.Fatal()
	}
}
