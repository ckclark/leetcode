package leetcode

import "testing"

func TestValidMountainArray(t *testing.T) {
	if validMountainArray([]int{1, 2, 3, 2, 1}) != true {
		t.Fatal()
	}
	if validMountainArray([]int{1, 2, 3, 4, 5}) != false {
		t.Fatal()
	}
	if validMountainArray([]int{}) != false {
		t.Fatal()
	}
	if validMountainArray([]int{1}) != false {
		t.Fatal()
	}
	if validMountainArray([]int{1, 2}) != false {
		t.Fatal()
	}
	if validMountainArray([]int{2, 1}) != false {
		t.Fatal()
	}
	if validMountainArray([]int{1, 2, 1}) != true {
		t.Fatal()
	}
}
