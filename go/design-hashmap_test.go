package leetcode

import "testing"

func TestHashMap(t *testing.T) {
	hm := Constructor()
	hm.Put(1, 1)
	hm.Put(2, 2)
	if hm.Get(1) != 1 {
		t.Fatal()
	}
	if hm.Get(3) != -1 {
		t.Fatal()
	}
	hm.Put(2, 1)
	if hm.Get(2) != 1 {
		t.Fatal()
	}
	hm.Remove(2)
	if hm.Get(2) != -1 {
		t.Fatal()
	}
}
