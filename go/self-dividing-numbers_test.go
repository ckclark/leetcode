package leetcode

import (
	"reflect"
	"testing"
)

func TestSelfDividingNumbers(t *testing.T) {
	if !reflect.DeepEqual(selfDividingNumbers(1, 22), []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22}) {
		t.Fatal()
	}
}
