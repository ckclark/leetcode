package leetcode

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func middleNode(head *ListNode) *ListNode {
	tmp := head
	n := 0
	for tmp != nil {
		tmp = tmp.Next
		n++
	}
	n /= 2
	for ; n > 0; n-- {
		head = head.Next
	}
	return head
}
