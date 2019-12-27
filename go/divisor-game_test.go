package leetcode

import "testing"

func TestDivisorGame(t *testing.T) {
	if divisorGame(2) != true {
		t.Fatal()
	}
	if divisorGame(3) != false {
		t.Fatal()
	}
}
