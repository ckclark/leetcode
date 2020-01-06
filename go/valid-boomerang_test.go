package leetcode

import "testing"

func TestIsBoomerang(t *testing.T) {
	if isBoomerang([][]int{
		[]int{1, 1},
		[]int{2, 3},
		[]int{3, 2},
	}) != true {
		t.Fatal()
	}
	if isBoomerang([][]int{
		[]int{1, 1},
		[]int{2, 2},
		[]int{3, 3},
	}) != false {
		t.Fatal()
	}
}
