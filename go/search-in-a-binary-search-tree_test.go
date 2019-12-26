package leetcode

import (
	"reflect"
	"testing"
)

func TestSearchBST(t *testing.T) {
	tree := &TreeNode{
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
			Val: 7,
		},
	}
	if !reflect.DeepEqual(searchBST(tree, 2), &TreeNode{
		Val: 2,
		Left: &TreeNode{
			Val: 1,
		},
		Right: &TreeNode{
			Val: 3,
		},
	}) {
		t.Fatal()
	}

	if searchBST(tree, 5) != nil {
		t.Fatal()
	}
}
