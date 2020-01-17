package leetcode

func prisonAfterNDays(cells []int, N int) []int {
	size := len(cells)
	encoded := 0
	for i, v := range cells {
		encoded |= v << uint(i)
	}
	visit := make(map[int]int)
	visit[encoded] = 0
	seq := make(map[int]int)
	seq[0] = encoded

	for x := 1; x <= N; x++ {
		nxt := 0
		for i := 1; i < size-1; i++ {
			if ((encoded>>uint(i-1))&1)^((encoded>>uint(i+1))&1) == 0 {
				nxt |= 1 << uint(i)
			}
		}
		encoded = nxt
		if prev, ok := visit[encoded]; ok {
			v := (N-x)%(x-prev) + prev
			ans := make([]int, size)
			for t := 0; t < size; t++ {
				ans[t] = (seq[v] >> uint(t)) & 1
			}
			return ans
		} else {
			visit[encoded] = x
			seq[x] = encoded
		}
	}
	ans := make([]int, size)
	for t := 0; t < size; t++ {
		ans[t] = (encoded >> uint(t)) & 1
	}
	return ans
}
