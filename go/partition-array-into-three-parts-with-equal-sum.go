package leetcode

func canThreePartsEqualSum(A []int) bool {
	lA := len(A)
	s := 0
	for _, v := range A {
		s += v
	}
	if s%3 != 0 {
		return false
	}
	left := 0
	var i int
	for i = 0; i < lA-2; i++ {
		left += A[i]
		if left == s/3 {
			break
		}
	}
	if i == lA-2 {
		return false
	}
	i++
	mid := 0
	for ; i < lA-1; i++ {
		mid += A[i]
		if mid == s/3 {
			break
		}
	}
	return i != lA-1
}
