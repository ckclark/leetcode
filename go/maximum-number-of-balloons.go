package leetcode

func maxNumberOfBalloons(text string) int {
	count := make(map[rune]int)
	for _, c := range text {
		count[c]++
	}
	ans := len(text) / 7
	var x int
	x = count['b']
	if x < ans {
		ans = x
	}
	x = count['a']
	if x < ans {
		ans = x
	}
	x = count['l'] / 2
	if x < ans {
		ans = x
	}
	x = count['o'] / 2
	if x < ans {
		ans = x
	}
	x = count['n']
	if x < ans {
		ans = x
	}
	return ans
}
