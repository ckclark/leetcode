package leetcode

import "testing"

func TestLeafSimilar(t *testing.T) {
	q1 := &TreeNode{
		Val: 3,
		Left: &TreeNode{
			Val: 5,
			Left: &TreeNode{
				Val: 6,
			},
			Right: &TreeNode{
				Val: 2,
				Left: &TreeNode{
					Val: 7,
				},
				Right: &TreeNode{
					Val: 4,
				},
			},
		},
		Right: &TreeNode{
			Val: 1,
			Left: &TreeNode{
				Val: 9,
			},
			Right: &TreeNode{
				Val: 8,
			},
		},
	}
	q2 := &TreeNode{
		Val: 3,
		Left: &TreeNode{
			Val: 5,
			Left: &TreeNode{
				Val: 0,
				Right: &TreeNode{
					Val: 6,
				},
			},
			Right: &TreeNode{
				Val: 2,
				Left: &TreeNode{
					Val: 7,
				},
				Right: &TreeNode{
					Val: 4,
				},
			},
		},
		Right: &TreeNode{
			Val: 1,
			Left: &TreeNode{
				Val: 9,
			},
			Right: &TreeNode{
				Val: 8,
			},
		},
	}
	if leafSimilar(q1, q2) != true {
		t.Fatal()
	}
}
