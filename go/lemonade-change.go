package leetcode

func lemonadeChange(bills []int) bool {
	c5, c10 := 0, 0
	for _, v := range bills {
		switch v {
		case 5:
			c5++
		case 10:
			if c5 < 1 {
				return false
			}
			c5--
			c10++
		case 20:
			if c10 > 0 {
				c10--
				if c5 < 1 {
					return false
				}
				c5--
			} else {
				if c5 < 3 {
					return false
				}
				c5 -= 3
			}
		}
	}
	return true
}
