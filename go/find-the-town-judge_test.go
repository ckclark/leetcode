package leetcode

import "testing"

func TestFindJudge(t *testing.T) {
	if findJudge(2, [][]int{[]int{1, 2}}) != 2 {
		t.Fatal()
	}
	if findJudge(3, [][]int{
		[]int{1, 3},
		[]int{2, 3},
	}) != 3 {
		t.Fatal()
	}
	if findJudge(3, [][]int{
		[]int{1, 3},
		[]int{2, 3},
		[]int{3, 1},
	}) != -1 {
		t.Fatal()
	}
	if findJudge(3, [][]int{
		[]int{1, 2},
		[]int{2, 3},
	}) != -1 {
		t.Fatal()
	}
	if findJudge(4, [][]int{
		[]int{1, 3},
		[]int{1, 4},
		[]int{2, 3},
		[]int{2, 4},
		[]int{4, 3},
	}) != 3 {
		t.Fatal()
	}
}
