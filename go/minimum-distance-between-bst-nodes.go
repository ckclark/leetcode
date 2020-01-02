package leetcode

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func inOrder(cur *TreeNode, c chan *TreeNode) {
	if cur != nil {
		inOrder(cur.Left, c)
		c <- cur
		inOrder(cur.Right, c)
	}
}

func minDiffInBST(root *TreeNode) int {
	c := make(chan *TreeNode)
	go func() {
		inOrder(root, c)
		close(c)
	}()
	var prev *TreeNode = nil
	minDiff := -1
	for v := range c {
		if prev != nil && (minDiff == -1 || v.Val-prev.Val < minDiff) {
			minDiff = v.Val - prev.Val
		}
		prev = v
	}
	return minDiff
}
