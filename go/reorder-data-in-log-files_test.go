package leetcode

import (
	"fmt"
	"reflect"
	"testing"
)

func TestReorderLogFiles(t *testing.T) {
	for _, s := range reorderLogFiles([]string{"dig1 8 1 5 1",
		"let1 art can",
		"dig2 3 6",
		"let2 own kit dig",
		"let3 art zero",
	}) {
		fmt.Println(s)
	}
	if !reflect.DeepEqual(reorderLogFiles([]string{"dig1 8 1 5 1",
		"let1 art can",
		"dig2 3 6",
		"let2 own kit dig",
		"let3 art zero",
	}),
		[]string{"let1 art can",
			"let3 art zero",
			"let2 own kit dig",
			"dig1 8 1 5 1",
			"dig2 3 6",
		}) {
		t.Fatal()
	}
}
