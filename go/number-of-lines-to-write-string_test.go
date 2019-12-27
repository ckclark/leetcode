package leetcode

import (
	"reflect"
	"testing"
)

func TestNumberOfLines(t *testing.T) {
	w1, s1 := []int{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "abcdefghijklmnopqrstuvwxyz"
	if !reflect.DeepEqual(numberOfLines(w1, s1), []int{3, 60}) {
		t.Fatal()
	}

	w2, s2 := []int{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "bbbcccdddaaa"
	if !reflect.DeepEqual(numberOfLines(w2, s2), []int{2, 4}) {
		t.Fatal()
	}
}
