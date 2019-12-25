package leetcode

import "testing"

func TestGetDecimalValue(t *testing.T) {
	if getDecimalValue(nil) != 0 {
		t.Fatal()
	}
	r := ListNode{1, &ListNode{0, &ListNode{1, nil}}}
	if getDecimalValue(&r) != 5 {
		t.Fatal()
	}
}
