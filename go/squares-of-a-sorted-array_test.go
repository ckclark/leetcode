package leetcode

import (
	"reflect"
	"testing"
)

func TestSortedSquares(t *testing.T) {
	if !reflect.DeepEqual(sortedSquares([]int{-4, -1, 0, 3, 10}), []int{0, 1, 9, 16, 100}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(sortedSquares([]int{-7, -3, 2, 3, 11}), []int{4, 9, 9, 49, 121}) {
		t.Fatal()
	}
}
