package leetcode

func selfDividingNumbers(left int, right int) []int {
	ans := make([]int, 0, right-left+1)
	for n := left; n <= right; n++ {
		t := n
		for t > 0 {
			v := t % 10
			if v == 0 || n%v != 0 {
				break
			}
			t /= 10
		}
		if t == 0 {
			ans = append(ans, n)
		}
	}
	return ans
}
