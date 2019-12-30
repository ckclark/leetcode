package leetcode

import "testing"

func TestMaxNumberOfBalloons(t *testing.T) {
	if maxNumberOfBalloons("nlaebolko") != 1 {
		t.Fatal()
	}
	if maxNumberOfBalloons("loonbalxballpoon") != 2 {
		t.Fatal()
	}
	if maxNumberOfBalloons("leetcode") != 0 {
		t.Fatal()
	}
	if maxNumberOfBalloons("balloon") != 1 {
		t.Fatal()
	}
}
