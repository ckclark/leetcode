package leetcode

import (
	"reflect"
	"testing"
)

func TestIncreasingBST(t *testing.T) {
	tree := &TreeNode{
		Val: 5,
		Left: &TreeNode{
			Val: 3,
			Left: &TreeNode{
				Val: 2,
				Left: &TreeNode{
					Val: 1,
				},
			},
			Right: &TreeNode{
				Val: 4,
			},
		},
		Right: &TreeNode{
			Val: 6,
			Right: &TreeNode{
				Val: 8,
				Left: &TreeNode{
					Val: 7,
				},
				Right: &TreeNode{
					Val: 9,
				},
			},
		},
	}
	ans := increasingBST(tree)
	if !reflect.DeepEqual(ans, &TreeNode{
		Val: 1,
		Right: &TreeNode{
			Val: 2,
			Right: &TreeNode{
				Val: 3,
				Right: &TreeNode{
					Val: 4,
					Right: &TreeNode{
						Val: 5,
						Right: &TreeNode{
							Val: 6,
							Right: &TreeNode{
								Val: 7,
								Right: &TreeNode{
									Val: 8,
									Right: &TreeNode{
										Val: 9,
									},
								},
							},
						},
					},
				},
			},
		},
	}) {
		t.Fatal()
	}

	tree2 := &TreeNode{
		Val: 826,
		Left: &TreeNode{
			Val: 379,
		},
	}

	ans2 := increasingBST(tree2)

	if !reflect.DeepEqual(ans2, &TreeNode{
		Val: 379,
		Right: &TreeNode{
			Val: 826,
		},
	}) {
		t.Fatal()
	}
}
