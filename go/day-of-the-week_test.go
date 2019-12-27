package leetcode

import "testing"

func TestDayOfTheWeek(t *testing.T) {
	if dayOfTheWeek(31, 8, 2019) != "Saturday" {
		t.Fatal()
	}
	if dayOfTheWeek(18, 7, 1999) != "Sunday" {
		t.Fatal()
	}
	if dayOfTheWeek(15, 8, 1993) != "Sunday" {
		t.Fatal()
	}
}
