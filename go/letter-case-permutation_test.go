package leetcode

import (
	"reflect"
	"testing"
)

func TestLetterCasePermutation(t *testing.T) {
	if !reflect.DeepEqual(letterCasePermutation("a1b2"), []string{"a1b2", "a1B2", "A1b2", "A1B2"}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(letterCasePermutation("3z4"), []string{"3z4", "3Z4"}) {
		t.Fatal()
	}
	if !reflect.DeepEqual(letterCasePermutation("12345"), []string{"12345"}) {
		t.Fatal()
	}
}
