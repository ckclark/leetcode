package leetcode

import (
	"reflect"
	"testing"
)

func TestPrefixesDivBy5(t *testing.T) {
	if !reflect.DeepEqual(prefixesDivBy5([]int{0, 1, 1}), []bool{true, false, false}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(prefixesDivBy5([]int{1, 1, 1}), []bool{false, false, false}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(prefixesDivBy5([]int{0, 1, 1, 1, 1, 1}), []bool{true, false, false, false, true, false}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(prefixesDivBy5([]int{1, 1, 1, 0, 1}), []bool{false, false, false, false, false}) {
		t.Fatal()
	}
}
