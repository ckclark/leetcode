package leetcode

import (
	"reflect"
	"testing"
)

func TestGardenNoAdj(t *testing.T) {
	if !reflect.DeepEqual(gardenNoAdj(3, [][]int{
		[]int{1, 2},
		[]int{2, 3},
		[]int{3, 1},
	}), []int{1, 2, 3}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(gardenNoAdj(4, [][]int{
		[]int{1, 2},
		[]int{3, 4},
	}), []int{1, 2, 1, 2}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(gardenNoAdj(4, [][]int{
		[]int{1, 2},
		[]int{2, 3},
		[]int{3, 4},
		[]int{4, 1},
		[]int{1, 3},
		[]int{2, 4},
	}), []int{1, 2, 3, 4}) {
		t.Fatal()
	}
}
