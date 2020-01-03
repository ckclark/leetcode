package leetcode

func isRectangleOverlap(rec1 []int, rec2 []int) bool {
	var l, r, t, b int
	if rec1[0] < rec2[0] {
		l = rec2[0]
	} else {
		l = rec1[0]
	}
	if rec1[2] < rec2[2] {
		r = rec1[2]
	} else {
		r = rec2[2]
	}
	if rec1[1] < rec2[1] {
		b = rec2[1]
	} else {
		b = rec1[1]
	}
	if rec1[3] < rec2[3] {
		t = rec1[3]
	} else {
		t = rec2[3]
	}
	return t > b && r > l
}
