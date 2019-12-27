package leetcode

import (
	"reflect"
	"testing"
)

func TestShortestToChar(t *testing.T) {
	if !reflect.DeepEqual(shortestToChar("loveleetcode", byte('e')), []int{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(shortestToChar("aaba", byte('b')), []int{2, 1, 0, 1}) {
		t.Fatal()
	}
}
