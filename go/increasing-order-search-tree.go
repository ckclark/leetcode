package leetcode

func InOrder(cur *TreeNode, tail **TreeNode) {
	if cur != nil {
		InOrder(cur.Left, tail)
		(**tail).Right = cur
		(**tail).Left = nil
		*tail = cur
		InOrder(cur.Right, tail)
	}
}

func increasingBST(root *TreeNode) *TreeNode {
	tmp := &TreeNode{}
	out := tmp
	InOrder(root, &tmp)
	tmp.Left = nil
	return out.Right
}
