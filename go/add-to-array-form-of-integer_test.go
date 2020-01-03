package leetcode

import (
	"reflect"
	"testing"
)

func TestAddToArrayForm(t *testing.T) {
	if !reflect.DeepEqual(addToArrayForm([]int{1, 2, 0, 0}, 34), []int{1, 2, 3, 4}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(addToArrayForm([]int{2, 7, 4}, 181), []int{4, 5, 5}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(addToArrayForm([]int{2, 1, 5}, 806), []int{1, 0, 2, 1}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(addToArrayForm([]int{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1), []int{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}) {
		t.Fatal()
	}
}
