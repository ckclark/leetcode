package leetcode

import "testing"

func TestNumRookCaptures(t *testing.T) {
	q1 := [][]byte{
		[]byte{'.', '.', '.', '.', '.', '.', '.', '.'},
		[]byte{'.', '.', '.', 'p', '.', '.', '.', '.'},
		[]byte{'.', '.', '.', 'R', '.', '.', '.', 'p'},
		[]byte{'.', '.', '.', '.', '.', '.', '.', '.'},
		[]byte{'.', '.', '.', '.', '.', '.', '.', '.'},
		[]byte{'.', '.', '.', 'p', '.', '.', '.', '.'},
		[]byte{'.', '.', '.', '.', '.', '.', '.', '.'},
		[]byte{'.', '.', '.', '.', '.', '.', '.', '.'},
	}
	if numRookCaptures(q1) != 3 {
		t.Fatal()
	}
	q2 := [][]byte{
		[]byte{'.', '.', '.', '.', '.', '.', '.', '.'},
		[]byte{'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
		[]byte{'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
		[]byte{'.', 'p', 'B', 'R', 'B', 'p', '.', '.'},
		[]byte{'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
		[]byte{'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
		[]byte{'.', '.', '.', '.', '.', '.', '.', '.'},
		[]byte{'.', '.', '.', '.', '.', '.', '.', '.'},
	}
	if numRookCaptures(q2) != 0 {
		t.Fatal()
	}
	q3 := [][]byte{
		[]byte{'.', '.', '.', '.', '.', '.', '.', '.'},
		[]byte{'.', '.', '.', 'p', '.', '.', '.', '.'},
		[]byte{'.', '.', '.', 'p', '.', '.', '.', '.'},
		[]byte{'p', 'p', '.', 'R', '.', 'p', 'B', '.'},
		[]byte{'.', '.', '.', '.', '.', '.', '.', '.'},
		[]byte{'.', '.', '.', 'B', '.', '.', '.', '.'},
		[]byte{'.', '.', '.', 'p', '.', '.', '.', '.'},
		[]byte{'.', '.', '.', '.', '.', '.', '.', '.'},
	}
	if numRookCaptures(q3) != 3 {
		t.Fatal()
	}
}
