package leetcode

import (
	"reflect"
	"sort"
	"testing"
)

func TestSubdomainVisits(t *testing.T) {
	ans1 := subdomainVisits([]string{"9001 discuss.leetcode.com"})
	sort.Strings(ans1)
	if !reflect.DeepEqual(ans1,
		[]string{
			"9001 com",
			"9001 discuss.leetcode.com",
			"9001 leetcode.com",
		}) {
		t.Fatal()
	}
	ans2 := subdomainVisits([]string{
		"900 google.mail.com",
		"50 yahoo.com",
		"1 intel.mail.com",
		"5 wiki.org",
	})
	sort.Strings(ans2)
	if !reflect.DeepEqual(ans2,
		[]string{
			"1 intel.mail.com",
			"5 org",
			"5 wiki.org",
			"50 yahoo.com",
			"900 google.mail.com",
			"901 mail.com",
			"951 com",
		}) {
		t.Fatal()
	}
}
