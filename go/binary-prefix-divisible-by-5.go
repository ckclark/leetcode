package leetcode

func prefixesDivBy5(A []int) []bool {
	ans := make([]bool, len(A))
	m := 0
	t := [][]int{
		[]int{0, 1},
		[]int{2, 3},
		[]int{4, 0},
		[]int{1, 2},
		[]int{3, 4},
	}
	for i, v := range A {
		m = t[m][v]
		ans[i] = m == 0
	}
	return ans
}
