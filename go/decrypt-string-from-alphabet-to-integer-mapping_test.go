package leetcode

import "testing"

func TestFreqAlphabets(t *testing.T) {
	if freqAlphabets("10#11#12") != "jkab" {
		t.Fatal()
	}
	if freqAlphabets("1326#") != "acz" {
		t.Fatal()
	}
	if freqAlphabets("25#") != "y" {
		t.Fatal()
	}
	if freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#") != "abcdefghijklmnopqrstuvwxyz" {
		t.Fatal()
	}
}
