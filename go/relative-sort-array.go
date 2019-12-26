package leetcode

import "sort"

func relativeSortArray(arr1 []int, arr2 []int) []int {
	inv := make(map[int]int)
	for idx, v := range arr2 {
		inv[v] = idx
	}

	sort.Slice(arr1, func(i, j int) bool {
		idx1, ok1 := inv[arr1[i]]
		idx2, ok2 := inv[arr1[j]]
		switch {
		case ok1 && ok2:
			return idx1 < idx2
		case ok1:
			return true
		case ok2:
			return false
		default:
			return arr1[i] < arr1[j]
		}
	})
	return arr1
}
