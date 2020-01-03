package leetcode

import (
	"reflect"
	"sort"
	"testing"
)

func TestPowerfulIntegers(t *testing.T) {
	v := powerfulIntegers(3, 5, 15)
	sort.Ints(v)
	if !reflect.DeepEqual(v, []int{2, 4, 6, 8, 10, 14}) {
		t.Fatal()
	}
}
