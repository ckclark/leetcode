package leetcode

func subtractProductAndSum(n int) int {
	p, s := 1, 0
	for n > 0 {
		v := n % 10
		p *= v
		s += v
		n /= 10
	}
	return p - s
}
