package leetcode

import "testing"

func TestToGoatLatin(t *testing.T) {
	if toGoatLatin("I speak Goat Latin") != "Imaa peaksmaaa oatGmaaaa atinLmaaaaa" {
		t.Fatal()
	}
}
