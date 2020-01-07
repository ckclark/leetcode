package leetcode

func replaceElements(arr []int) []int {
	max := -1
	n := len(arr)
	for i := n - 1; i >= 0; i-- {
		toset := max
		if max < arr[i] {
			max = arr[i]
		}
		arr[i] = toset
	}
	return arr
}
