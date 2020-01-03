package leetcode

func pivotIndex(nums []int) int {
	ln := len(nums)
	left, right := 0, 0
	for _, v := range nums {
		right += v
	}
	for i := 0; i < ln; i++ {
		right -= nums[i]
		if left == right {
			return i
		}
		left += nums[i]
	}
	return -1
}
