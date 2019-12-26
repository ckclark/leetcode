package leetcode

import "sort"

func minimumAbsDifference(arr []int) [][]int {
	sort.Ints(arr)
	l := len(arr)
	diff := arr[l-1] - arr[0]
	for i := 1; i < l; i++ {
		if arr[i]-arr[i-1] < diff {
			diff = arr[i] - arr[i-1]
		}
	}
	ans := make([][]int, 0, l)
	for i := 1; i < l; i++ {
		if arr[i]-arr[i-1] == diff {
			ans = append(ans, []int{arr[i-1], arr[i]})
		}
	}
	return ans
}
