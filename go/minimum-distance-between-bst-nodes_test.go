package leetcode

import "testing"

func TestMinDiffInBST(t *testing.T) {
	if minDiffInBST(&TreeNode{
		Val: 4,
		Left: &TreeNode{
			Val: 2,
			Left: &TreeNode{
				Val: 1,
			},
			Right: &TreeNode{
				Val: 3,
			},
		},
		Right: &TreeNode{
			Val: 6,
		},
	}) != 1 {
		t.Fatal()
	}
}
