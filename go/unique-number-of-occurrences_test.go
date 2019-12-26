package leetcode

import "testing"

func TestUniqueOccurrences(t *testing.T) {
	if uniqueOccurrences([]int{1, 2, 2, 1, 1, 3}) != true {
		t.Fatal()
	}
	if uniqueOccurrences([]int{1, 2}) != false {
		t.Fatal()
	}
	if uniqueOccurrences([]int{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}) != true {
		t.Fatal()
	}
}
