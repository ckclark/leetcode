package leetcode

type RecentCounter struct {
	buffer []int
	offset int
}

func Constructor() RecentCounter {
	return RecentCounter{buffer: []int{}}
}

func (this *RecentCounter) Ping(t int) int {
	for this.offset < len(this.buffer) && this.buffer[this.offset]+3000 < t {
		this.offset++
	}
	this.buffer = append(this.buffer, t)
	ans := len(this.buffer) - this.offset
	return ans
}
