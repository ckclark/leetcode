package leetcode

import "testing"

func TestShortestCompletingWord(t *testing.T) {
	if shortestCompletingWord("1s3 PSt", []string{"step", "steps", "stripe", "stepple"}) != "steps" {
		t.Fatal()
	}
	if shortestCompletingWord("1s3 456", []string{"looks", "pest", "stew", "show"}) != "pest" {
		t.Fatal()
	}
}
