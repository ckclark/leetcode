package leetcode

import (
	"reflect"
	"testing"
)

func TestCommonChars(t *testing.T) {
	if !reflect.DeepEqual(commonChars([]string{"bella", "label", "roller"}), []string{"e", "l", "l"}) {
		t.Fatal()
	}
}
