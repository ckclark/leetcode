package leetcode

import (
	"reflect"
	"testing"
)

func TestUncommonFromSentences(t *testing.T) {
	A1, B1 := "this apple is sweet", "this apple is sour"
	ans1 := []string{"sweet", "sour"}

	if !reflect.DeepEqual(uncommonFromSentences(A1, B1), ans1) {
		t.Fatal()
	}

	A2, B2 := "apple apple", "banana"
	ans2 := []string{"banana"}

	if !reflect.DeepEqual(uncommonFromSentences(A2, B2), ans2) {
		t.Fatal()
	}
}
