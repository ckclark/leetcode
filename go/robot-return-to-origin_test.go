package leetcode

import "testing"

func TestJudgeCircle(t *testing.T) {
	if judgeCircle("UD") != true {
		t.Fatal()
	}
	if judgeCircle("LL") != false {
		t.Fatal()
	}
}
