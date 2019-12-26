package leetcode

import (
	"reflect"
	"testing"
)

func TestRelativeSortArray(t *testing.T) {
	if !reflect.DeepEqual(relativeSortArray(
		[]int{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19},
		[]int{2, 1, 4, 3, 9, 6}),
		[]int{2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19}) {
		t.Fatal()
	}
}
