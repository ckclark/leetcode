package leetcode

import (
	"reflect"
	"testing"
)

func TestShiftGrid(t *testing.T) {
	if !reflect.DeepEqual(shiftGrid([][]int{
		[]int{1, 2, 3},
		[]int{4, 5, 6},
		[]int{7, 8, 9},
	}, 1),
		[][]int{
			[]int{9, 1, 2},
			[]int{3, 4, 5},
			[]int{6, 7, 8},
		}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(shiftGrid([][]int{
		[]int{3, 8, 1, 9},
		[]int{19, 7, 2, 5},
		[]int{4, 6, 11, 10},
		[]int{12, 0, 21, 13},
	}, 4),
		[][]int{
			[]int{12, 0, 21, 13},
			[]int{3, 8, 1, 9},
			[]int{19, 7, 2, 5},
			[]int{4, 6, 11, 10},
		}) {
		t.Fatal()
	}
}
