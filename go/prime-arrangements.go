package leetcode

func numPrimeArrangements(n int) int {
	const MODULUS = 1000000007
	primes := []int{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97}
	nprime := 25
	L, U := -1, nprime
	for L+1 < U {
		m := (L + U) / 2
		if primes[m] > n {
			U = m
		} else {
			L = m
		}
	}
	// (n - U)! * U!
	var ans uint64 = 1
	for i := 1; i <= n-U; i++ {
		ans *= uint64(i)
		ans %= MODULUS
	}
	for i := 1; i <= U; i++ {
		ans *= uint64(i)
		ans %= MODULUS
	}
	return int(ans)
}
