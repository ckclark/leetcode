package leetcode

import "testing"

func TestSortArrayByParityII(t *testing.T) {
	ans := sortArrayByParityII([]int{4, 2, 5, 7})
	for i, v := range ans {
		if (i^v)&1 != 0 {
			t.Fatal()
		}
	}
}
