package leetcode

import (
	"reflect"
	"testing"
)

func TestNumMovesStones(t *testing.T) {
	if !reflect.DeepEqual(numMovesStones(1, 2, 5), []int{1, 2}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(numMovesStones(4, 3, 2), []int{0, 0}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(numMovesStones(3, 5, 1), []int{1, 2}) {
		t.Fatal()
	}
}
