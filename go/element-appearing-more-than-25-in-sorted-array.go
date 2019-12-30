package leetcode

func findSpecialInteger(arr []int) int {
	l := len(arr)
	quarter := l / 4

	for i := 0; i < l; i++ {
		if arr[i] == arr[i+quarter] {
			return arr[i]
		}
	}
	return -1
}
