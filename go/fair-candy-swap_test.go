package leetcode

import (
	"reflect"
	"testing"
)

func TestFairCandySwap(t *testing.T) {
	if !reflect.DeepEqual(fairCandySwap([]int{1, 2, 5}, []int{2, 4}), []int{5, 4}) {
		t.Fatal()
	}
}
