package leetcode

import "testing"

func TestSurfaceArea(t *testing.T) {
	if surfaceArea([][]int{[]int{2}}) != 10 {
		t.Fatal()
	}

	if surfaceArea([][]int{
		[]int{1, 2},
		[]int{3, 4},
	}) != 34 {
		t.Fatal()
	}

	if surfaceArea([][]int{
		[]int{1, 0},
		[]int{0, 2},
	}) != 16 {
		t.Fatal()
	}

	if surfaceArea([][]int{
		[]int{1, 1, 1},
		[]int{1, 0, 1},
		[]int{1, 1, 1},
	}) != 32 {
		t.Fatal()
	}

	if surfaceArea([][]int{
		[]int{2, 2, 2},
		[]int{2, 1, 2},
		[]int{2, 2, 2},
	}) != 46 {
		t.Fatal()
	}
}
