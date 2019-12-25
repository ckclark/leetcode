package leetcode

func getDecimalValue(head *ListNode) int {
	t := head
	ans := 0
	for t != nil {
		ans <<= 1
		ans |= t.Val
		t = t.Next
	}
	return ans
}
