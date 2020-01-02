package leetcode

func findJudge(N int, trust [][]int) int {
	indeg, outdeg := make([]int, N), make([]int, N)
	for _, t := range trust {
		indeg[t[1]-1]++
		outdeg[t[0]-1]++
	}
	for i := 0; i < N; i++ {
		if indeg[i] == N-1 && outdeg[i] == 0 {
			return i + 1
		}
	}
	return -1
}
