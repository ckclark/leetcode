package leetcode

func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for i, v := range nums {
		if idx, ok := m[target-v]; ok {
			return []int{idx, i}
		} else {
			m[v] = i
		}
	}
	return []int{}
}
