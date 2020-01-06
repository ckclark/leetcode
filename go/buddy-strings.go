package leetcode

func buddyStrings(A string, B string) bool {
	if A == B {
		dup := make(map[rune]struct{})
		for _, c := range A {
			if _, ok := dup[c]; ok {
				return true
			}
			dup[c] = struct{}{}
		}
		return false
	}
	chA, chB := byte(0), byte(0)
	lA, lB := len(A), len(B)
	if lA != lB {
		return false
	}
	changed := false
	for i := 0; i < lA; i++ {
		if A[i] != B[i] {
			if changed {
				return false
			} else if chA == 0 {
				chA, chB = A[i], B[i]
			} else if chB == A[i] && chA == B[i] {
				changed = true
			} else {
				return false
			}
		}
	}
	return changed
}
