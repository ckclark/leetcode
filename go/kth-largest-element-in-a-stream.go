package leetcode

import "container/heap"

type minHeap []int

func (h minHeap) Len() int {
	return len(h)
}

func (h minHeap) Less(i, j int) bool {
	return h[i] < h[j]
}

func (h minHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *minHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *minHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[:n-1]
	return x
}

type KthLargest struct {
	firstK minHeap
	k      int
}

func Constructor(k int, nums []int) KthLargest {
	firstK := minHeap(nums)
	heap.Init(&firstK)
	for len(firstK) > k {
		heap.Pop(&firstK)
	}
	return KthLargest{
		firstK: firstK,
		k:      k,
	}
}

func (this *KthLargest) Add(val int) int {
	heap.Push(&this.firstK, val)
	for len(this.firstK) > this.k {
		heap.Pop(&this.firstK)
	}
	return this.firstK[0]
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * obj := Constructor(k, nums);
 * param_1 := obj.Add(val);
 */
