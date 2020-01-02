package leetcode

import "testing"

func TestTwoCitySchedCost(t *testing.T) {
	if twoCitySchedCost([][]int{
		[]int{10, 20},
		[]int{30, 200},
		[]int{400, 50},
		[]int{30, 20},
	}) != 110 {
		t.Fatal()
	}
}
