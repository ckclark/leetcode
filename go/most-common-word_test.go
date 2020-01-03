package leetcode

import "testing"

func TestMostCommonWord(t *testing.T) {
	if mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", []string{"hit"}) != "ball" {
		t.Fatal()
	}
}
