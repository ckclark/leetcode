package leetcode

import (
	"reflect"
	"testing"
)

func TestFindOcurrences(t *testing.T) {
	ans1 := findOcurrences("alice is a good girl she is a good student", "a", "good")
	if !reflect.DeepEqual(ans1, []string{"girl", "student"}) {
		t.Fatal()
	}
	ans2 := findOcurrences("we will we will rock you", "we", "will")
	if !reflect.DeepEqual(ans2, []string{"we", "rock"}) {
		t.Fatal()
	}
	ans3 := findOcurrences("we we we rock you", "we", "we")
	if !reflect.DeepEqual(ans3, []string{"we", "rock"}) {
		t.Fatal()
	}
}
