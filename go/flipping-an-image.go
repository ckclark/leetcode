package leetcode

func flipAndInvertImage(A [][]int) [][]int {
	for _, row := range A {
		l := len(row)
		i, j := 0, l-1
		for i < j {
			row[i], row[j] = row[j]^1, row[i]^1
			i++
			j--
		}
		if i == j {
			row[i] ^= 1
		}
	}
	return A
}
