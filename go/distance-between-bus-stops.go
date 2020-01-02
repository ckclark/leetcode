package leetcode

func distanceBetweenBusStops(distance []int, start int, destination int) int {
	n := len(distance)
	s := 0
	for _, v := range distance {
		s += v
	}
	p := 0
	for t := start; t != destination; t = (t + 1) % n {
		p += distance[t]
	}
	if p > s-p {
		return s - p
	} else {
		return p
	}
}
