package leetcode

import (
	"fmt"
	"testing"
)

func TestRepeatedNTimes(t *testing.T) {
	fmt.Println(repeatedNTimes([]int{1, 2, 3, 3}))
	if repeatedNTimes([]int{1, 2, 3, 3}) != 3 {
		t.Fatal()
	}
	if repeatedNTimes([]int{2, 1, 2, 5, 3, 2}) != 2 {
		t.Fatal()
	}
	if repeatedNTimes([]int{5, 1, 5, 2, 5, 3, 5, 4}) != 5 {
		t.Fatal()
	}
}
