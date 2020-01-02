package leetcode

func search(nums []int, target int) int {
	L, U := -1, len(nums)
	for L+1 < U {
		m := (L + U) / 2
		if nums[m] == target {
			return m
		}
		if nums[m] > target {
			U = m
		} else {
			L = m
		}
	}
	return -1
}
