package leetcode

import "testing"

func TestHasGroupsSizeX(t *testing.T) {
	if hasGroupsSizeX([]int{1, 2, 3, 4, 4, 3, 2, 1}) != true {
		t.Fatal()
	}
	if hasGroupsSizeX([]int{1, 1, 1, 2, 2, 2, 3, 3}) != false {
		t.Fatal()
	}
	if hasGroupsSizeX([]int{1}) != false {
		t.Fatal()
	}
	if hasGroupsSizeX([]int{1, 1}) != true {
		t.Fatal()
	}
	if hasGroupsSizeX([]int{1, 1, 2, 2, 2, 2}) != true {
		t.Fatal()
	}
}
