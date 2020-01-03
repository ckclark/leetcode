package leetcode

import "testing"

func TestNextGreatestLetter(t *testing.T) {
	if nextGreatestLetter([]byte("cfj"), byte('a')) != byte('c') {
		t.Fatal()
	}
	if nextGreatestLetter([]byte("cfj"), byte('c')) != byte('f') {
		t.Fatal()
	}
	if nextGreatestLetter([]byte("cfj"), byte('d')) != byte('f') {
		t.Fatal()
	}
	if nextGreatestLetter([]byte("cfj"), byte('g')) != byte('j') {
		t.Fatal()
	}
	if nextGreatestLetter([]byte("cfj"), byte('j')) != byte('c') {
		t.Fatal()
	}
	if nextGreatestLetter([]byte("cfj"), byte('k')) != byte('c') {
		t.Fatal()
	}
}
