package leetcode

import (
	"container/heap"
)

type IntHeap []int

func (h IntHeap) Len() int {
	return len(h)
}

func (h IntHeap) Less(i, j int) bool {
	return h[i] > h[j]
}

func (h IntHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *IntHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *IntHeap) Pop() interface{} {
	oldh := *h
	x := oldh[len(oldh)-1]
	newh := oldh[0 : len(oldh)-1]
	*h = newh
	return x
}

func lastStoneWeight(stones []int) int {
	h := IntHeap(stones)
	heap.Init(&h)
	for len(h) > 1 {
		v1 := heap.Pop(&h).(int)
		v2 := heap.Pop(&h).(int)
		if v1 > v2 {
			heap.Push(&h, v1-v2)
		} else if v1 < v2 {
			heap.Push(&h, v2-v2)
		}
	}
	if len(h) == 0 {
		return 0
	} else {
		return h[0]
	}
}
