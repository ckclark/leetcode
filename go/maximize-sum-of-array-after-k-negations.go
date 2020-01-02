package leetcode

import (
	"sort"
)

type byAbs []int

func (b byAbs) Len() int {
	return len(b)
}

func (b byAbs) Less(i, j int) bool {
	x, y := b[i], b[j]
	if x < 0 {
		x = -x
	}
	if y < 0 {
		y = -y
	}
	return x > y
}

func (b byAbs) Swap(i, j int) {
	b[i], b[j] = b[j], b[i]
}

func largestSumAfterKNegations(A []int, K int) int {
	ans := 0
	sort.Sort(byAbs(A))
	for _, v := range A {
		if v < 0 && K > 0 {
			ans -= v
			K--
		} else {
			ans += v
		}
	}
	if K%2 == 1 {
		if A[len(A)-1] < 0 {
			ans += 2 * A[len(A)-1]
		} else {
			ans -= 2 * A[len(A)-1]
		}
	}
	return ans
}
