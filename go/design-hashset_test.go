package main

import "testing"

func TestHashSet(t *testing.T) {
	hs := Constructor()
	hs.Add(1)
	hs.Add(2)
	if hs.Contains(1) != true {
		t.Fatal()
	}
	if hs.Contains(3) != false {
		t.Fatal()
	}
	hs.Add(2)
	if hs.Contains(2) != true {
		t.Fatal()
	}
	hs.Remove(2)
	if hs.Contains(2) != false {
		t.Fatal()
	}
}
