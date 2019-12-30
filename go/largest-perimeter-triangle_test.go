package leetcode

import "testing"

func TestLargestPerimeter(t *testing.T) {
	if largestPerimeter([]int{2, 1, 2}) != 5 {
		t.Fatal()
	}
	if largestPerimeter([]int{1, 2, 1}) != 0 {
		t.Fatal()
	}
	if largestPerimeter([]int{3, 2, 3, 4}) != 10 {
		t.Fatal()
	}
	if largestPerimeter([]int{3, 6, 2, 3}) != 8 {
		t.Fatal()
	}
}
