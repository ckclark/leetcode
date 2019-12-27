package leetcode

import "testing"

func TestSumRootToLeaf(t *testing.T) {
	q1 := &TreeNode{
		Val: 1,
		Left: &TreeNode{
			Val: 0,
			Left: &TreeNode{
				Val: 0,
			},
			Right: &TreeNode{
				Val: 1,
			},
		},
		Right: &TreeNode{
			Val: 1,
			Left: &TreeNode{
				Val: 0,
			},
			Right: &TreeNode{
				Val: 1,
			},
		},
	}
	if sumRootToLeaf(q1) != 22 {
		t.Fatal()
	}
}
