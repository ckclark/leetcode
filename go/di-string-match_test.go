package leetcode

import (
	"reflect"
	"testing"
)

func TestDiStringMatch(t *testing.T) {
	if !reflect.DeepEqual(diStringMatch("IDID"), []int{2, 3, 1, 4, 0}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(diStringMatch("III"), []int{0, 1, 2, 3}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(diStringMatch("DDI"), []int{2, 1, 0, 3}) {
		t.Fatal()
	}
}
