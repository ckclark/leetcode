package leetcode

import "testing"

func TestLemonadeChange(t *testing.T) {
	if lemonadeChange([]int{5, 5, 5, 10, 20}) != true {
		t.Fatal()
	}
	if lemonadeChange([]int{5, 5, 10}) != true {
		t.Fatal()
	}
	if lemonadeChange([]int{10, 10}) != false {
		t.Fatal()
	}
}
