package leetcode

import (
	"reflect"
	"testing"
)

type Prob struct {
	arr    []int
	target int
}

type Expected []int

func TestTwoSum(t *testing.T) {
	q := Prob{[]int{1, 2, 3}, 5}
	e := Expected([]int{1, 2})
	if !reflect.DeepEqual(twoSum(q.arr, q.target), []int(e)) {
		t.Fatalf("%v %v", q, e)
	}
}
