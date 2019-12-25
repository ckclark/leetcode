package leetcode

import (
	"strconv"
)

func findNumbers(nums []int) int {
	ans := 0
	for _, v := range nums {
		ans += (len(strconv.Itoa(v)) & 1) ^ 1
	}
	return ans
}
