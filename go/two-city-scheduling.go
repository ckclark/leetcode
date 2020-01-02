package leetcode

import "sort"

type people struct {
	A    int
	B    int
	diff int
}

type bydiff []people

func (ps bydiff) Len() int {
	return len(ps)
}

func (ps bydiff) Less(i, j int) bool {
	return ps[i].diff < ps[j].diff
}

func (ps bydiff) Swap(i, j int) {
	ps[i], ps[j] = ps[j], ps[i]
}

func twoCitySchedCost(costs [][]int) int {
	n := len(costs)
	p := make(bydiff, 0, n)
	for _, cost := range costs {
		p = append(p, people{
			A:    cost[0],
			B:    cost[1],
			diff: cost[0] - cost[1],
		})
	}
	sort.Sort(p)
	ans := 0
	for i := 0; i < n/2; i++ {
		ans += p[i].A
	}
	for i := n / 2; i < n; i++ {
		ans += p[i].B
	}
	return ans
}
