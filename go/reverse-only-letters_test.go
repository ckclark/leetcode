package leetcode

import "testing"

func TestReverseOnlyLetters(t *testing.T) {
	if reverseOnlyLetters("ab-cd") != "dc-ba" {
		t.Fatal()
	}
	if reverseOnlyLetters("a-bC-dEf-ghIj") != "j-Ih-gfE-dCba" {
		t.Fatal()
	}
	if reverseOnlyLetters("Test1ng-Leet=code-Q!") != "Qedo1ct-eeLg=ntse-T!" {
		t.Fatal()
	}
}
