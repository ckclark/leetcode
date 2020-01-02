package leetcode

import "fmt"

func rotatedDigits(N int) int {
	dec := false
	// 0 1 2 5 6 8 9
	tN := 0
	for t := 10000; t > 0; t /= 10 {
		tN *= 7
		if !dec {
			d := (N / t) % 10
			switch d {
			case 0:
				tN += 0
			case 1:
				tN += 1
			case 2:
				tN += 2
			case 3, 4:
				tN += 2
				dec = true
			case 5:
				tN += 3
			case 6:
				tN += 4
			case 7:
				tN += 4
				dec = true
			case 8:
				tN += 5
			case 9:
				tN += 6
			}
		} else {
			tN += 6
		}
	}
	fmt.Printf("tN = %d\n", tN)
	same := 0
	dec = false
	for t := 7 * 7 * 7 * 7; t > 0; t /= 7 {
		d := (tN / t) % 7
		same *= 3
		if !dec {
			switch d {
			case 0:
				same += 0
			case 1:
				same += 1
			case 2, 3, 4:
				same += 1
				dec = true
			case 5:
				same += 2
			case 6:
				same += 2
				dec = true
			}
		} else {
			same += 2
		}
	}
	return tN - same
}
