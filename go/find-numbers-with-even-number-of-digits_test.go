package leetcode

import (
	"fmt"
	"testing"
)

func TestFindNumbers(t *testing.T) {
	fmt.Println(findNumbers([]int{12, 345, 2, 6, 7896}) == 2)
	fmt.Println(findNumbers([]int{555, 901, 482, 1771}) == 1)
}
