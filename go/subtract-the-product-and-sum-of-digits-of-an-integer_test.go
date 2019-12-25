package leetcode

import "testing"

func TestSubtractProductAndSum(t *testing.T) {
	if subtractProductAndSum(234) != 15 {
		t.Fatal()
	}
	if subtractProductAndSum(4421) != 21 {
		t.Fatal()
	}
	if subtractProductAndSum(114) != -2 {
		t.Fatal()
	}
}
