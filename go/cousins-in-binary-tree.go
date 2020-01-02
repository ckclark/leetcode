package leetcode

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type info struct {
	depth  int
	parent int
}

func findDepth(depth int, cur *TreeNode, x, y int, c chan info) {
	if cur.Left != nil {
		if cur.Left.Val == x {
			c <- info{depth: depth, parent: cur.Val}
		}
		if cur.Left.Val == y {
			c <- info{depth: depth, parent: cur.Val}
		}
		findDepth(depth+1, cur.Left, x, y, c)
	}
	if cur.Right != nil {
		if cur.Right.Val == x {
			c <- info{depth: depth, parent: cur.Val}
		}
		if cur.Right.Val == y {
			c <- info{depth: depth, parent: cur.Val}
		}
		findDepth(depth+1, cur.Right, x, y, c)
	}
}

func isCousins(root *TreeNode, x int, y int) bool {
	if root == nil {
		return false
	}
	if root.Val == x || root.Val == y {
		return false
	}
	c := make(chan info)
	go findDepth(0, root, x, y, c)
	a := <-c
	b := <-c

	return a.depth == b.depth && a.parent != b.parent
}
