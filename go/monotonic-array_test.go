package leetcode

import "testing"

func TestIsMonotonic(t *testing.T) {
	if isMonotonic([]int{1, 2, 2, 3}) != true {
		t.Fatal()
	}
	if isMonotonic([]int{6, 5, 4, 4}) != true {
		t.Fatal()
	}
	if isMonotonic([]int{1, 3, 2}) != false {
		t.Fatal()
	}
	if isMonotonic([]int{1, 2, 4, 5}) != true {
		t.Fatal()
	}
	if isMonotonic([]int{1, 1, 1}) != true {
		t.Fatal()
	}
}
