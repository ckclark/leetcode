package leetcode

func numPairsDivisibleBy60(time []int) int {
	bucket := make([]int, 60)
	ans := 0
	for _, t := range time {
		ans += bucket[(60-t%60)%60]
		bucket[t%60]++
	}
	return ans
}
