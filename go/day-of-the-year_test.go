package leetcode

import "testing"

func TestDayOfYear(t *testing.T) {
	if dayOfYear("2019-01-09") != 9 {
		t.Fatal()
	}
	if dayOfYear("2019-02-10") != 41 {
		t.Fatal()
	}
	if dayOfYear("2003-03-01") != 60 {
		t.Fatal()
	}
	if dayOfYear("2004-03-01") != 61 {
		t.Fatal()
	}
}
