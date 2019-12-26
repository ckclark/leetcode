package leetcode

import (
	"testing"
)

func TestHeightChecker(t *testing.T) {
	if heightChecker([]int{1, 1, 4, 2, 1, 3}) != 3 {
		t.Fatal()
	}
}
