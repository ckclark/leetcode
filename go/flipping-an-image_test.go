package leetcode

import (
	"reflect"
	"testing"
)

func TestFlipAndInvertImage(t *testing.T) {
	prob1 := [][]int{[]int{1, 1, 0}, []int{1, 0, 1}, []int{0, 0, 0}}
	ans1 := [][]int{[]int{1, 0, 0}, []int{0, 1, 0}, []int{1, 1, 1}}
	if !reflect.DeepEqual(flipAndInvertImage(prob1), ans1) {
		t.Fatal()
	}
	prob2 := [][]int{[]int{1, 1, 0, 0}, []int{1, 0, 0, 1}, []int{0, 1, 1, 1}, []int{1, 0, 1, 0}}
	ans2 := [][]int{[]int{1, 1, 0, 0}, []int{0, 1, 1, 0}, []int{0, 0, 0, 1}, []int{1, 0, 1, 0}}
	if !reflect.DeepEqual(flipAndInvertImage(prob2), ans2) {
		t.Fatal()
	}
}
