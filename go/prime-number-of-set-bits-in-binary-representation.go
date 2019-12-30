package leetcode

func c(n, m int) int {
	if n < m {
		return 0
	}
	if m > n-m {
		m = n - m
	}
	ans := 1
	for i := 1; i <= m; i++ {
		ans *= n - i + 1
		ans /= i
	}
	return ans
}

func countBits(n int) int {
	n = (n & 0x55555555) + ((n >> 1) & 0x55555555)
	n = (n & 0x33333333) + ((n >> 2) & 0x33333333)
	n = (n & 0x0f0f0f0f) + ((n >> 4) & 0x0f0f0f0f)
	n = (n & 0x00ff00ff) + ((n >> 8) & 0x00ff00ff)
	n = (n & 0x0000ffff) + ((n >> 16) & 0x0000ffff)
	return n
}

func countPrimeSetBitsBounded(N int) int {
	if N <= 2 {
		return 0
	}
	N++
	ans := 0
	for t := 20; t >= 0; t-- {
		if (1<<uint(t))&N > 0 {
			n := (((-(1 << uint(t))) & N) >> uint(t)) - 1
			if n >= 0 {
				bits := countBits(n)
				for _, p := range []int{2, 3, 5, 7, 11, 13, 17, 19} {
					if p >= bits {
						ans += c(t, p-bits)
					}
				}
			}
		}
	}
	return ans
}

func countPrimeSetBits(L int, R int) int {
	return countPrimeSetBitsBounded(R) - countPrimeSetBitsBounded(L-1)
}
