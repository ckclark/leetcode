package leetcode

func judgeCircle(moves string) bool {
	h, v := 0, 0
	for _, c := range moves {
		switch c {
		case 'U':
			v++
		case 'D':
			v--
		case 'L':
			h--
		case 'R':
			h++
		}
	}
	return h == 0 && v == 0
}
