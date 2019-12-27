package leetcode

func findComplement(num int) int {
	x := num
	x |= x >> 1
	x |= x >> 2
	x |= x >> 4
	x |= x >> 8
	x |= x >> 16
	x >>= 1
	return ^num & x
}
