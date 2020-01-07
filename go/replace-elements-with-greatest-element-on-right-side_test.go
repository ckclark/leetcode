package leetcode

import (
	"reflect"
	"testing"
)

func TestReplaceElements(t *testing.T) {
	if !reflect.DeepEqual(replaceElements([]int{17, 18, 5, 4, 6, 1}), []int{18, 6, 6, 6, 1, -1}) {
		t.Fatal()
	}
}
