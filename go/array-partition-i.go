package leetcode

import "sort"

func arrayPairSum(nums []int) int {
	sort.Ints(nums)
	l := len(nums)
	ans := 0
	for i := 0; i < l; i += 2 {
		ans += nums[i]
	}
	return ans
}
