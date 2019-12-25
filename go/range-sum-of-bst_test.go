package leetcode

import "testing"

func TestRangeSumBST(t *testing.T) {
	root := TreeNode{
		Val: 3,
		Left: &TreeNode{
			Val: 1,
		},
		Right: &TreeNode{
			Val: 4,
		},
	}
	if rangeSumBST(&root, 2, 5) != 7 {
		t.Fatal()
	}
}
