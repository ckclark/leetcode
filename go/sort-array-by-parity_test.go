package leetcode

import (
	"reflect"
	"testing"
)

func TestSortArrayByParity(t *testing.T) {
	if !reflect.DeepEqual(sortArrayByParity([]int{3, 1, 2, 4}), []int{4, 2, 1, 3}) {
		t.Fatal()
	}
}
