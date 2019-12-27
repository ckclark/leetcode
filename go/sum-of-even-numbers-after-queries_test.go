package leetcode

import (
	"reflect"
	"testing"
)

func TestSumEvenAfterQueries(t *testing.T) {
	A1, q1, ans1 := []int{1, 2, 3, 4},
		[][]int{
			[]int{1, 0},
			[]int{-3, 1},
			[]int{-4, 0},
			[]int{2, 3},
		}, []int{8, 6, 2, 4}
	if !reflect.DeepEqual(sumEvenAfterQueries(A1, q1), ans1) {
		t.Fatal()
	}
}
