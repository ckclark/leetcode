package leetcode

import (
	"reflect"
	"testing"
)

func TestNumSmallerByFrequency(t *testing.T) {
	if !reflect.DeepEqual(
		numSmallerByFrequency(
			[]string{"cbd"},
			[]string{"zaaaz"}), []int{1}) {
		t.Fatal()
	}

	if !reflect.DeepEqual(
		numSmallerByFrequency(
			[]string{"bbb", "cc"},
			[]string{"a", "aa", "aaa", "aaaa"}), []int{1, 2}) {
		t.Fatal()
	}
}
