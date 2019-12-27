package leetcode

func sum(cur *TreeNode, n int, ans *int) {
	if cur != nil {
		n = (n << 1) + cur.Val
		if cur.Left == nil && cur.Right == nil {
			*ans += n
		} else {
			sum(cur.Left, n, ans)
			sum(cur.Right, n, ans)
		}
	}
}

func sumRootToLeaf(root *TreeNode) int {
	ans := 0
	sum(root, 0, &ans)
	return ans
}
