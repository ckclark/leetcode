package leetcode

import "testing"

func TestBuddyStrings(t *testing.T) {
	if buddyStrings("ab", "ba") != true {
		t.Fatal()
	}
	if buddyStrings("ab", "ab") != false {
		t.Fatal()
	}
	if buddyStrings("aa", "aa") != true {
		t.Fatal()
	}
	if buddyStrings("aaaaaabc", "aaaaaacb") != true {
		t.Fatal()
	}
	if buddyStrings("", "aa") != false {
		t.Fatal()
	}
}
