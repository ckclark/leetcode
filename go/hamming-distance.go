package leetcode

func hammingDistance(x int, y int) int {
	xor := x ^ y
	xor = (xor & 0x55555555) + ((xor >> 1) & 0x55555555)
	xor = (xor & 0x33333333) + ((xor >> 2) & 0x33333333)
	xor = (xor & 0x0f0f0f0f) + ((xor >> 4) & 0x0f0f0f0f)
	xor = (xor & 0x00ff00ff) + ((xor >> 8) & 0x00ff00ff)
	xor = (xor & 0x0000ffff) + ((xor >> 16) & 0x0000ffff)
	return xor
}
