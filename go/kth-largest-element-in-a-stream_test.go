package leetcode

import "testing"

func TestKthLargestElementInAStream(t *testing.T) {
	kth := Constructor(3, []int{4, 5, 8, 2})
	if kth.Add(3) != 4 {
		t.Fatal()
	}
	if kth.Add(5) != 5 {
		t.Fatal()
	}
	if kth.Add(10) != 5 {
		t.Fatal()
	}
	if kth.Add(9) != 8 {
		t.Fatal()
	}
	if kth.Add(4) != 8 {
		t.Fatal()
	}
}
