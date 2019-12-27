package leetcode

import (
	"reflect"
	"testing"
)

func TestAllCellsDistOrder(t *testing.T) {
	ans1 := allCellsDistOrder(1, 2, 0, 0)
	if !reflect.DeepEqual(ans1, [][]int{[]int{0, 0}, []int{0, 1}}) {
		t.Fatal()
	}
}
