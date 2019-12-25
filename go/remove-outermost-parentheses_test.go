package leetcode

import (
	"testing"
)

func TestRemoveOuterParentheses(t *testing.T) {
	if removeOuterParentheses("(()())(())") != "()()()" {
		t.Fatal()
	}
	if removeOuterParentheses("(()())(())(()(()))") != "()()()()(())" {
		t.Fatal()
	}
}
