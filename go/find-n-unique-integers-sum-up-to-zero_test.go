package leetcode

import "testing"

func TestSumZero(t *testing.T) {
	for _, n := range []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10} {
		out := sumZero(n)
		if len(out) != n {
			t.Fatal()
		}
		v := 0
		for _, x := range out {
			v += x
		}
		if v != 0 {
			t.Fatal()
		}
	}
}
