package leetcode

import (
	"reflect"
	"testing"
)

func TestPrisonAfterNDays(t *testing.T) {
	if !reflect.DeepEqual(prisonAfterNDays([]int{0, 1, 0, 1, 1, 0, 0, 1}, 7),
		[]int{0, 0, 1, 1, 0, 0, 0, 0}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(prisonAfterNDays([]int{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000),
		[]int{0, 0, 1, 1, 1, 1, 1, 0}) {
		t.Fatal()
	}
}
