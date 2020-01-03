package leetcode

import (
	"reflect"
	"testing"
)

func TestLargeGroupPositions(t *testing.T) {
	if !reflect.DeepEqual(largeGroupPositions("abbxxxxzzy"), [][]int{
		[]int{3, 6},
	}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(largeGroupPositions("abc"), [][]int{}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(largeGroupPositions("abcdddeeeeaabbbcd"), [][]int{
		[]int{3, 5},
		[]int{6, 9},
		[]int{12, 14},
	}) {
		t.Fatal()
	}
}
