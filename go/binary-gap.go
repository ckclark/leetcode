package leetcode

func binaryGap(N int) int {
	prev := -1
	ans := 0
	for i := 0; (1 << uint(i)) <= N; i++ {
		if (1<<uint(i))&N > 0 {
			if prev != -1 && i-prev > ans {
				ans = i - prev
			}
			prev = i
		}
	}
	return ans
}
