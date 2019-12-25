package leetcode

func numJewelsInStones(J string, S string) int {
	isJewel := make(map[rune]struct{})
	for _, c := range J {
		isJewel[c] = struct{}{}
	}
	ans := 0
	for _, c := range S {
		if _, ok := isJewel[c]; ok {
			ans++
		}
	}
	return ans
}
