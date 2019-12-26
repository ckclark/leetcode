package leetcode

import "testing"

func TestNumUniqueEmails(t *testing.T) {
	if numUniqueEmails([]string{
		"test.email@leetcode.com",
		"test.email+alex@leetcode.com",
		"test.e.mail+bob.cathy@leetcode.com",
		"testemail+david@lee.tcode.com",
	}) != 2 {
		t.Fatal()
	}
}
