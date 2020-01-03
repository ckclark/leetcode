package leetcode

func nextGreatestLetter(letters []byte, target byte) byte {
	min := byte(255)
	min2 := byte(255)
	for _, b := range letters {
		if b > target && b < min {
			min = b
		}
		if b < min2 {
			min2 = b
		}
	}
	if min != byte(255) {
		return min
	}
	return min2
}
