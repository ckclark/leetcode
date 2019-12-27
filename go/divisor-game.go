package leetcode

func divisorGame(N int) bool {
	table := make(map[int]bool)
	table[1] = false
	for i := 2; i <= 1000; i++ {
		win := false
		for j := 1; j*j <= i; j++ {
			if i%j == 0 {
				if !table[i-j] {
					win = true
					break
				}
				if j > 1 && !table[i-i/j] {
					win = true
					break
				}
			}
		}
		table[i] = win
	}
	return table[N]
}
