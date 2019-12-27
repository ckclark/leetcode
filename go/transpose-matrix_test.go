package leetcode

import (
	"reflect"
	"testing"
)

func TestTranspose(t *testing.T) {
	q1 := [][]int{
		[]int{1, 2, 3},
		[]int{4, 5, 6},
		[]int{7, 8, 9},
	}
	a1 := [][]int{
		[]int{1, 4, 7},
		[]int{2, 5, 8},
		[]int{3, 6, 9},
	}
	if !reflect.DeepEqual(transpose(q1), a1) {
		t.Fatal()
	}
}
