package leetcode

func fairCandySwap(A []int, B []int) []int {
	sA, sB := 0, 0
	for _, v := range A {
		sA += v
	}

	for _, v := range B {
		sB += v
	}

	m := make(map[int]struct{})
	for _, v := range A {
		m[v] = struct{}{}
	}
	for _, v := range B {
		if _, ok := m[v-(sB-sA)/2]; ok {
			return []int{v - (sB-sA)/2, v}
		}
	}
	return nil
}
