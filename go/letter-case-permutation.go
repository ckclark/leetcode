package leetcode

import "unicode"

func iterate(depth int, array []rune, c chan<- string) {
	if depth == len(array) {
		c <- string(array)
		return
	}
	if unicode.IsLetter(array[depth]) {
		array[depth] = unicode.ToLower(array[depth])
		iterate(depth+1, array, c)
		array[depth] = unicode.ToUpper(array[depth])
		iterate(depth+1, array, c)
	} else {
		iterate(depth+1, array, c)
	}
}

func letterCasePermutation(S string) []string {
	c := make(chan string)
	go func() {
		iterate(0, []rune(S), c)
		close(c)
	}()

	ans := make([]string, 0, 1<<uint(len(S)))
	for s := range c {
		ans = append(ans, s)
	}
	return ans
}
