package leetcode

import "testing"

func TestToLowerCase(t *testing.T) {
	if toLowerCase("Hello") != "hello" {
		t.Fatal()
	}
	if toLowerCase("here") != "here" {
		t.Fatal()
	}
	if toLowerCase("LOVELY") != "lovely" {
		t.Fatal()
	}
}
