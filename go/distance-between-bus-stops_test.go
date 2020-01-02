package leetcode

import "testing"

func TestDistanceBetweenBusStops(t *testing.T) {
	if distanceBetweenBusStops([]int{1, 2, 3, 4}, 0, 1) != 1 {
		t.Fatal()
	}
	if distanceBetweenBusStops([]int{1, 2, 3, 4}, 0, 2) != 3 {
		t.Fatal()
	}
}
