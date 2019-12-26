package leetcode

import "testing"

func TestRecentCounter(t *testing.T) {
	obj := Constructor()
	inputs := []int{1, 100, 3001, 3002}
	expected := []int{1, 2, 3, 3}
	for i := 0; i < 4; i++ {
		if obj.Ping(inputs[i]) != expected[i] {
			t.Fatal()
		}
	}
}
