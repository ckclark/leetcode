package leetcode

func bitwiseComplement(N int) int {
	if N == 0 {
		return 1
	}
	t := N
	t |= t >> 1
	t |= t >> 2
	t |= t >> 4
	t |= t >> 8
	t |= t >> 16
	return t ^ N
}
