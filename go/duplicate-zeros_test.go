package leetcode

import (
	"reflect"
	"testing"
)

func TestDuplicateZeros(t *testing.T) {
	arr := []int{1, 0, 2, 3, 0, 4, 5, 0}
	duplicateZeros(arr)
	if !reflect.DeepEqual(arr, []int{1, 0, 0, 2, 3, 0, 0, 4}) {
		t.Fatal()
	}
	arr2 := []int{1, 2, 3}
	duplicateZeros(arr2)
	if !reflect.DeepEqual(arr2, []int{1, 2, 3}) {
		t.Fatal()
	}
	arr3 := []int{1, 0}
	duplicateZeros(arr3)
	if !reflect.DeepEqual(arr3, []int{1, 0}) {
		t.Fatal()
	}
}
