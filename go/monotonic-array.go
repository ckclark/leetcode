package leetcode

func isMonotonic(A []int) bool {
	lA := len(A)
	if lA <= 1 {
		return true
	}
	check := false
	var increasing bool
	for idx, n := range A {
		if idx > 0 {
			prev := A[idx-1]
			if !check {
				if n > prev {
					increasing = true
					check = true
				} else if n < prev {
					increasing = false
					check = true
				}
			} else {
				if n != prev {
					if increasing != (n > prev) {
						return false
					}
				}
			}
		}
	}
	return true
}
