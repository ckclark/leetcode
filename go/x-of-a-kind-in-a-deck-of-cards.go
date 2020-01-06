package leetcode

func gcd(a, b int) int {
	for a%b != 0 {
		a, b = b, a%b
	}
	return b
}

func hasGroupsSizeX(deck []int) bool {
	cnt := make(map[int]int)
	for _, v := range deck {
		cnt[v]++
	}
	g := 0
	for _, v := range cnt {
		g = gcd(g, v)
	}
	return g > 1
}
