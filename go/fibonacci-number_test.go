package leetcode

import "testing"

func TestFib(t *testing.T) {
	if fib(0) != 0 {
		t.Fatal()
	}
	if fib(2) != 1 {
		t.Fatal()
	}
	if fib(3) != 2 {
		t.Fatal()
	}
	if fib(4) != 3 {
		t.Fatal()
	}
}
