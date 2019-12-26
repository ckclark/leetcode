package leetcode

func fib(N int) int {
	a, b := 0, 1
	fib_ary := make([]int, 31)
	for i := 0; i <= 30; i++ {
		fib_ary[i] = a
		a, b = b, a+b
	}
	return fib_ary[N]
}
