package leetcode

import (
	"reflect"
	"testing"
)

func TestMinimumAbsDifference(t *testing.T) {
	if !reflect.DeepEqual(minimumAbsDifference([]int{4, 2, 1, 3}),
		[][]int{
			[]int{1, 2},
			[]int{2, 3},
			[]int{3, 4},
		}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(minimumAbsDifference([]int{1, 3, 6, 10, 15}),
		[][]int{
			[]int{1, 3},
		}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(minimumAbsDifference([]int{3, 8, -10, 23, 19, -4, -14, 27}),
		[][]int{
			[]int{-14, -10},
			[]int{19, 23},
			[]int{23, 27},
		}) {
		t.Fatal()
	}
}
