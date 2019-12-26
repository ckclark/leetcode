package leetcode

func isUnivalTree(root *TreeNode) bool {
	if root == nil {
		return true
	}
	if root.Left != nil {
		if root.Left.Val != root.Val || !isUnivalTree(root.Left) {
			return false
		}
	}
	if root.Right != nil {
		if root.Right.Val != root.Val || !isUnivalTree(root.Right) {
			return false
		}
	}
	return true
}
