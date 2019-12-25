package leetcode

func mergeTrees(t1 *TreeNode, t2 *TreeNode) *TreeNode {
	if t1 == nil && t2 == nil {
		return nil
	}
	if t1 != nil && t2 != nil {
		ans := &TreeNode{}
		ans.Val = t1.Val + t2.Val
		ans.Left = mergeTrees(t1.Left, t2.Left)
		ans.Right = mergeTrees(t1.Right, t2.Right)
		return ans
	} else if t1 != nil {
		return t1
	} else if t2 != nil {
		return t2
	}
	return nil
}
