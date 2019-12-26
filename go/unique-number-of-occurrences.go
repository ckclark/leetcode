package leetcode

func uniqueOccurrences(arr []int) bool {
	counter := make(map[int]int)
	for _, v := range arr {
		counter[v]++
	}
	vals := make(map[int]struct{})
	for _, v := range counter {
		if _, ok := vals[v]; ok {
			return false
		}
		vals[v] = struct{}{}
	}
	return true
}
