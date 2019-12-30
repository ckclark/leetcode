package leetcode

import (
	"reflect"
	"testing"
)

func TestDistributeCandies(t *testing.T) {
	if !reflect.DeepEqual(distributeCandies(7, 4), []int{1, 2, 3, 1}) {
		t.Fatal()
	}
}
