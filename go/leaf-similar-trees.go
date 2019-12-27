package leetcode

func leaves(cur *TreeNode, c chan int) {
	if cur != nil {
		if cur.Left == nil && cur.Right == nil {
			c <- cur.Val
		} else {
			leaves(cur.Left, c)
			leaves(cur.Right, c)
		}
	}
}

func leafSimilar(root1 *TreeNode, root2 *TreeNode) bool {
	chan1 := make(chan int)
	chan2 := make(chan int)
	go func() {
		leaves(root1, chan1)
		close(chan1)
	}()
	go func() {
		leaves(root2, chan2)
		close(chan2)
	}()
	for {
		v1, open1 := <-chan1
		v2, open2 := <-chan2
		if !open1 && !open2 {
			return true
		}
		if open1 != open2 {
			return false
		}
		if v1 != v2 {
			return false
		}
	}
}
