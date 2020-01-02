package leetcode

import (
	"reflect"
	"testing"
)

func TestFloodFill(t *testing.T) {
	if !reflect.DeepEqual(floodFill([][]int{
		[]int{1, 1, 1},
		[]int{1, 1, 0},
		[]int{1, 0, 1},
	}, 1, 1, 2), [][]int{
		[]int{2, 2, 2},
		[]int{2, 2, 0},
		[]int{2, 0, 1},
	}) {
		t.Fatal()
	}
}
