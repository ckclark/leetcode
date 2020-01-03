package leetcode

func gardenNoAdj(N int, paths [][]int) []int {
	neighbors := make([][]int, N)
	for i := 0; i < N; i++ {
		neighbors[i] = make([]int, 0, 3)
	}
	for _, path := range paths {
		neighbors[path[0]-1] = append(neighbors[path[0]-1], path[1]-1)
		neighbors[path[1]-1] = append(neighbors[path[1]-1], path[0]-1)
	}
	ans := make([]int, N)
	for i := 0; i < N; i++ {
		mask := 0
		for _, nb := range neighbors[i] {
			mask |= 1 << uint(ans[nb])
		}
		for j := 1; j <= 4; j++ {
			if mask&(1<<uint(j)) == 0 {
				ans[i] = j
				break
			}
		}
	}
	return ans
}
