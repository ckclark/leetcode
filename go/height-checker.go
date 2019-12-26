package leetcode

func heightChecker(heights []int) int {
	counter := make([]int, 101)
	for _, n := range heights {
		counter[n]++
	}
	offset := 0
	ans := 0
	for i := 1; i <= 100; i++ {
		for j := 0; j < counter[i]; j++ {
			if heights[offset] != i {
				ans++
			}
			offset++
		}
	}
	return ans
}
