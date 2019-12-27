package leetcode

func sumEvenAfterQueries(A []int, queries [][]int) []int {
	evens := 0
	for _, v := range A {
		if v%2 == 0 {
			evens += v
		}
	}
	ans := make([]int, len(A))
	for i, q := range queries {
		val, idx := q[0], q[1]
		if A[idx]%2 == 0 {
			evens -= A[idx]
		}
		A[idx] += val
		if A[idx]%2 == 0 {
			evens += A[idx]
		}
		ans[i] = evens
	}
	return ans
}
